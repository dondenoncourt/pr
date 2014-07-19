package daffron.fms.hr.payroll
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

// Note: do not read by key (get()) as there is no unique index on the table
class OtherEarningsHistory implements Serializable {
	int empNo
	Date payPeriodBeginDate
	Date payPeriodEndingDate
	Date payPeriodCheckDate
	BigDecimal totalOtherEarnings
	BigDecimal fwtOtherEarningsTaxable
	BigDecimal swtOtherEarningsTaxable
	BigDecimal ficaOtherEarningsTaxable
	BigDecimal loclOtherEarningsTaxable
	BigDecimal fuiOtherEarningsTaxable
	BigDecimal suiOtherEarningsTAxable
	BigDecimal wcompOtherEarningsTaxable
	String recordPreviouslyVoided
	static constraints = {
		empNo(max:999999999,nullable:false)
		payPeriodBeginDate(nullable:false)
		payPeriodEndingDate(nullable:false)
		payPeriodCheckDate(nullable:false)
		totalOtherEarnings(max:new BigDecimal("99999.99"),nullable:false)
		fwtOtherEarningsTaxable(max:new BigDecimal("99999.99"),nullable:false)
		swtOtherEarningsTaxable(max:new BigDecimal("99999.99"),nullable:false)
		ficaOtherEarningsTaxable(max:new BigDecimal("99999.99"),nullable:false)
		loclOtherEarningsTaxable(max:new BigDecimal("99999.99"),nullable:false)
		fuiOtherEarningsTaxable(max:new BigDecimal("99999.99"),nullable:false)
		suiOtherEarningsTAxable(max:new BigDecimal("99999.99"),nullable:false)
		wcompOtherEarningsTaxable(max:new BigDecimal("99999.99"),nullable:false)
		recordPreviouslyVoided(maxSize:1,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'prphoth', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['empNo','payPeriodBeginDate'])  // do not use, no unique key on this table
		columns {
			id (composite:['empNo','payPeriodBeginDate'])
			empNo (column:'HOEMP', type:'int')
			payPeriodBeginDate (column:'HOBEGD', type:'date')
			payPeriodEndingDate (column:'HOENDD', type:'date')
			payPeriodCheckDate (column:'HOCHKD', type:'date')
			totalOtherEarnings (column:'HOTAXE', type:'big_decimal')
			fwtOtherEarningsTaxable (column:'HOTFWT', type:'big_decimal')
			swtOtherEarningsTaxable (column:'HOTSWT', type:'big_decimal')
			ficaOtherEarningsTaxable (column:'HOTFIC', type:'big_decimal')
			loclOtherEarningsTaxable (column:'HOTLOC', type:'big_decimal')
			fuiOtherEarningsTaxable (column:'HOTFUI', type:'big_decimal')
			suiOtherEarningsTAxable (column:'HOTSUI', type:'big_decimal')
			wcompOtherEarningsTaxable (column:'HOTWC', type:'big_decimal')
			recordPreviouslyVoided (column:'HOVOID', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']

	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
}