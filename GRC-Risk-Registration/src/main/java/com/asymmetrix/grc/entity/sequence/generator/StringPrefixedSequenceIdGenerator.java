package com.asymmetrix.grc.entity.sequence.generator;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class StringPrefixedSequenceIdGenerator extends SequenceStyleGenerator {

	public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
	public static final String VALUE_PREFIX_DEFAULT = "RR_";
	private String valuePrefix;

	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT = "%d";
	private String numberFormat;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object){
		return valuePrefix + String.format(numberFormat, super.generate(session, object));
	}

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) {
		super.configure(LongType.INSTANCE, params, serviceRegistry);
		valuePrefix = org.hibernate.internal.util.config.ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, params,
				VALUE_PREFIX_DEFAULT);
		numberFormat = org.hibernate.internal.util.config.ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params,
				NUMBER_FORMAT_DEFAULT);
	}

}