package daffron.fms.hr

import org.springframework.beans.BeanWrapper
import org.springframework.beans.PropertyAccessorFactory
import daffron.fms.AuthorizedOperations
import daffron.fms.hr.AuthorizeOperation

class SecurityController {
	@AuthorizeOperation( level='9', text='Append authorized controller actions to XXPAUOPS' )
	def appendAuthorizedOperations = {
		// see http://www.intelligrape.com/blog/tag/groovy-annotation/
		// also see: http://burtbeckwith.com/blog/?p=80
		
		for (controller in grailsApplication.controllerClasses) {
			BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(controller.newInstance())
			for (pd in beanWrapper.propertyDescriptors) {
				String closureClassName = controller.getPropertyOrStaticPropertyOrFieldValue(pd.name, Closure)?.class?.name
				if (closureClassName) {
					def action = controller.clazz.declaredFields.find { field -> field.name == pd.name }
					AuthorizeOperation annotation = action.getAnnotation(daffron.fms.hr.AuthorizeOperation)
					if (annotation) {
						createAuthorizedOperations(controller, pd.name, annotation)
					}
				}
			}
			
			controller.metaClass.methods.each {method ->
				if (controller.isActionMethod(method.name)) {
					def mtd = controller.clazz.getMethod(method.name, [] as Class[])
					if (mtd.isAnnotationPresent(daffron.fms.hr.AuthorizeOperation)) {
						def annotation = mtd.getAnnotation(daffron.fms.hr.AuthorizeOperation)
						createAuthorizedOperations(controller, method.name, annotation)
					}
				}
			}
		}
		render "Generated AuthorizedOperations (XXPAUOPS)"
	}
	private def createAuthorizedOperations(def controller, def actionName, def annotation) {
		if (!AuthorizedOperations.findByControllerAndAction(controller.logicalPropertyName, actionName)) {
			Long maxId = AuthorizedOperations.maxId()
			Long maxAuthorityOperationId = AuthorizedOperations.maxAuthorityOperationId()?:grailsApplication.config.xxauops.min.op.id
			def ao = new AuthorizedOperations(
				authorityOperationId:++maxAuthorityOperationId,
				controller:controller.logicalPropertyName,
				action:actionName,
				securityLevel:annotation.level(),
				text:annotation.text()
			)
			ao.id = ++maxId
			if (!ao.save(flush:true)) {
				ao.errors.each{log.error it}
			}
		} else {
			log.debug "AuthorizedOperations already exists for ${controller.logicalPropertyName}/${actionName}"
		}
	}
}
