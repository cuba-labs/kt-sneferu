package groovy.sneferu.sample

import com.company.sample.entity.Employee
import com.company.sample.web.screens.employee.EmployeeBrowse
import com.company.sample.web.screens.employee.EmployeeEdit
import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.gui.ScreenBuilders
import com.haulmont.cuba.gui.util.FailedOperationResult
import com.haulmont.cuba.gui.util.SuccessOperationResult
import com.haulmont.cuba.web.app.main.MainScreen
import com.haulmont.cuba.web.testsupport.TestUiEnvironment
import com.haulmont.sneferu.ComponentDescriptors.button
import com.haulmont.sneferu.ComponentDescriptors.textField
import com.haulmont.sneferu.CubaWebUiTestAPI
import com.haulmont.sneferu.Interactions.*
import com.haulmont.sneferu.UiTestAPI
import groovy.sneferu.sample.testsupport.DemoTestContainer
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.ClassRule
import org.junit.Test
import spock.lang.Shared

class EmployeeEditTest {

    companion object {
        @JvmField
        @Shared
        @ClassRule
        val environment = TestUiEnvironment(DemoTestContainer.Common.INSTANCE)
                .withScreenPackages("com.company.sample.web.screens.employee")
                .withUserLogin("admin")
    }

    var uiTestAPI: UiTestAPI? = null

    @Before
    fun setup() {
        uiTestAPI = CubaWebUiTestAPI(
                environment,
                AppBeans.get(ScreenBuilders::class.java),
                MainScreen::class.java)
    }

    @Test
    fun checkEmployeeMandatoryFields() {
        val employeeBrowser = uiTestAPI!!
                .openStandardLookup(Employee::class.java, EmployeeBrowse::class.java)

        employeeBrowser.interact(
                click(button("createBtn")))

        val employeeEditor = uiTestAPI!!.getOpenedEditorScreen(EmployeeEdit::class.java)

        var outcome = employeeEditor.andThenGet(closeEditor())

        assertEquals(outcome, FailedOperationResult.INSTANCE)

        employeeEditor
                .interact(enter(textField("firstNameField"), "John"))
                .interact(enter(textField("lastNameField"), "Snow"))
                .interact(enter(textField("ageField"), 25))

        outcome = employeeEditor.andThenGet(closeEditor())

        assertEquals(outcome, SuccessOperationResult.INSTANCE)
    }
}