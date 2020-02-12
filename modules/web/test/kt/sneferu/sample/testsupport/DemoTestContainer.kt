package kt.sneferu.sample.testsupport

import com.haulmont.cuba.web.testsupport.TestContainer

open class DemoTestContainer() : TestContainer() {

    class Common private constructor() : DemoTestContainer() {
        @Throws(Throwable::class)
        override fun before() {
            if (!initialized) {
                super.before()
                initialized = true
            }
            setupContext()
        }

        override fun after() {
            cleanupContext()
            // never stops - do not call super
        }

        companion object {
            val INSTANCE: DemoTestContainer = DemoTestContainer()
            @Volatile
            private var initialized = false
        }
    }

    init {
        setAppComponents(listOf("com.haulmont.cuba"))
        setAppPropertiesFiles(listOf(
                "com/company/sample/web-app.properties",
                "kt/sneferu/sample/testsupport/test-app.properties"
        ))
    }
}