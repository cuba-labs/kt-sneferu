package com.company.sample

import com.haulmont.cuba.testsupport.TestContainer

open class SampleTestContainer : TestContainer() {
    init {
        appComponents = mutableListOf(
                "com.haulmont.cuba"
                // add CUBA premium add-ons here
                // "com.haulmont.bpm",
                // "com.haulmont.charts",
                // "com.haulmont.fts",
                // "com.haulmont.reports",
                // and custom app components if any
        )
        appPropertiesFiles = mutableListOf(
                // List the files defined in your web.xml
                // in appPropertiesConfig context parameter of the core module
                "com/company/sample/app.properties",
                // Add this file which is located in CUBA and defines some properties
                // specifically for test environment. You can replace it with your own
                // or add another one in the end.
                "com/haulmont/cuba/testsupport/test-app.properties")

        autoConfigureDataSource()
    }


    class Common private constructor() : SampleTestContainer() {

        @Throws(Throwable::class)
        public override fun before() {
            if (!initialized) {
                super.before()
                initialized = true
            }
            setupContext()
        }

        public override fun after() {
            cleanupContext()
            // never stops - do not call super
        }

        companion object {

            val INSTANCE = SampleTestContainer.Common()

            @Volatile
            private var initialized: Boolean = false
        }
    }
}