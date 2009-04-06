package com.modelmetrics.cloudconverter.forceutil;

import com.modelmetrics.cloudconverter.engine.MigrationContext;

public interface DataExecutor {

	public void execute(MigrationContext migrationContext) throws Exception;
	
}
