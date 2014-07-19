package daffron.fms.hr.enrollment

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
class Cafeteria {
	BigDecimal urmElectionPrior = 0g
	BigDecimal urmDeductionPrior = 0g  
	BigDecimal urmBalancePrior = 0g
	BigDecimal ddcElectionPrior = 0g
	BigDecimal ddcDeductionPrior = 0g
	BigDecimal ddcBalancePrior = 0g

	BigDecimal urmElection = 0g
	BigDecimal urmDeduction = 0g
	boolean	urmWaive = false 
	BigDecimal ddcElection = 0g
	BigDecimal ddcDeduction = 0g
	boolean	ddcWaive = false
	
	BigDecimal contribution = 0g
	
	String fsaRepayMethod = ''
	String fsaRepayActType = 'C'
	String fsaBankName = ''
	String fsaActNo = ''
	String fsaRoutingNo = ''
	
	static belongsTo = [enroll:Enroll]
	
	boolean populateMode = false
	static transients = ['populateMode']

	static FSA_REPAY_MAP = ['D':'Direct Deposit', 'M':'Mail']
	static FSA_REPAY_ACC_TYPE = ['C':'Checking', 'S':'Savings']
	static constraints = {
		fsaRepayMethod maxSize:1, nullable:true, blank:true, 
		               inList: FSA_REPAY_MAP.keySet() as List
						   
		fsaRepayActType maxSize:1, nullable:true, blank:true,
						inList: FSA_REPAY_ACC_TYPE.keySet() as List
		fsaRoutingNo matches:/^\d{9}$/, validator: {val, cafeteria ->
			if (cafeteria.fsaRepayMethod == 'D' && !cafeteria.populateMode) {
				if (val?.size() < 9) return false
				def n = 0;
				for (def i = 0; i < val.size(); i += 3) {
					n += val[i].toInteger() * 3
					n += val[i + 1].toInteger() * 7
					n += val[i + 2].toInteger()
				}
				return (n != 0 && n % 10 == 0)
			}
			return true
		}
		fsaBankName validator: {val, cafeteria ->
			if (cafeteria.fsaRepayMethod == 'D' && !cafeteria.populateMode) {
				if (val.size() < 2) {
					return false
				}
			}
			return true
		}
		fsaActNo validator: {val, cafeteria ->
			if (cafeteria.fsaRepayMethod == 'D' && !cafeteria.populateMode) {
				if (val.size() < 2) {
					return false
				}
			}
			return true
		}
		fsaRepayActType validator: {val, cafeteria ->
			if (cafeteria.fsaRepayMethod == 'D' && !cafeteria.populateMode) {
				if (!val) {
					return false
				}
			}
			return true
		}
		urmElection  validator: {val, cafeteria ->
			if (val==1234g) {
				return false
			}
		}		
	}
	static mapping = {
		table name:'hrpcafe', schema:CH.config.hr.schema
		urmWaive            column:'urmwaive', type:'org.hibernate.type.YesNoType'
		ddcWaive            column:'ddcwaive', type:'org.hibernate.type.YesNoType'
		urmElectionPrior   	column:'urmElecPr' , max:999999999.99g 
		urmDeductionPrior 	column:'urmDedPr'  , max:999999999.99g 
		urmBalancePrior 	column:'urmBalPr'  , max:999999999.99g 
		ddcElectionPrior 	column:'ddcElecPr' , max:999999999.99g 
		ddcDeductionPrior 	column:'ddcDedPr'  , max:999999999.99g 
		ddcBalancePrior 	column:'ddcBalPr'  , max:999999999.99g 
		urmElection 		column:'urmElec'   , max:999999999.99g 
		urmDeduction 		column:'urmDed'    , max:999999999.99g 
		ddcElection 		column:'ddcElec'   , max:999999999.99g 
		ddcDeduction 		column:'ddcDed'    , max:999999999.99g 
		fsaRepayMethod   	column:'fsaPayMtd'  
		fsaRepayActType 	column:'fsaPayAcTp'  
		fsaBankName 		column:'fsaBankNam' 
		fsaActNo 			column:'fsaActNo' 
		fsaRoutingNo 		column:'fsaRouting' 
	}

}
