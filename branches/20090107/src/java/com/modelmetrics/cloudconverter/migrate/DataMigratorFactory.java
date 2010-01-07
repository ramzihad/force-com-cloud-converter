/*
The MIT License

Copyright (c) 2008, 2009 Model Metrics, Inc.

http://ModelMetrics.com
http://ModelMetrics.com/authors/rcarlberg

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package com.modelmetrics.cloudconverter.migrate;

import com.modelmetrics.cloudconverter.migrate.struts2.ConflictResolutionType;
import com.modelmetrics.cloudconverter.migrate.struts2.MigrateContext;

public class DataMigratorFactory {

	public DataMigrator build(MigrateContext migrateContext) {

		DataMigrator ret = null;

		if (migrateContext.getConflict() == ConflictResolutionType.OVERWITE_WHEN_NOT_EMPTY) {
			ret = new DataMigratorOverwriteWhenNotEmpty();
		} else if (migrateContext.getConflict() == ConflictResolutionType.BOOLEAN_OVERWITE_WHEN_TRUE) {
			ret = new DataMigratorBooleanOverwriteWhenTrue();
		} else if (migrateContext.getConflict() == ConflictResolutionType.CONCATENATE_SOURCE_TO_TARGET) {
			ret = new DataMigratorContatenateSourceToTarget(migrateContext
					.getConcatenator());
		} else if (migrateContext.getConflict() == ConflictResolutionType.CONCATENATE_TARGET_TO_SOURCE) {
			ret = new DataMigratorContatenateTargetToSource(migrateContext
					.getConcatenator());
		} else if (migrateContext.getConflict() == ConflictResolutionType.FAIL_WHEN_BOTH_HAVE_DATA) {
			ret = new DataMigratorFailWhenBothHaveData();

		} else {
			ret = new DataMigratorAlwaysOverwrite();
		}

		return ret;

	}
}
