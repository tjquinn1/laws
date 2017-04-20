package com.bcsw

class Committee {
    String comName

    String comSummary
    String chamber


    static hasMany = [comMember: Rep]

    static constraints = {
    }
    String toString() {
        chamber + " - " + comName
    }
}
