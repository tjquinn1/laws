package com.bcsw

class Bill {
    String billPre
    String number
    String billName
    Integer dateIntro
    String summary

    static hasMany = [cosponsor: Rep, sponsor: Rep, committee: Committee]

    static constraints = {
        cosponsor nullable: true
        sponsor nullable: true
    }
    String toString() {
        billName
    }
}
