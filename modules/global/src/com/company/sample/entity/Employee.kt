package com.company.sample.entity

import com.haulmont.chile.core.annotations.NamePattern
import com.haulmont.cuba.core.entity.StandardEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

@NamePattern(value = "%s %s|firstName,lastName")
@Table(name = "SAMPLE_EMPLOYEE")
@Entity(name = "sample_Employee")
class Employee : StandardEntity() {
    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)
    var firstName: String? = null

    @NotNull
    @Column(name = "LAST_NAME", nullable = false)
    var lastName: String? = null

    @NotNull
    @Column(name = "AGE", nullable = false)
    var age: Int? = null

    @Column(name = "PHONE")
    var phone: String? = null

    @Column(name = "ADDRESS")
    var address: String? = null

    companion object {
        private const val serialVersionUID = -261543747808467981L
    }
}