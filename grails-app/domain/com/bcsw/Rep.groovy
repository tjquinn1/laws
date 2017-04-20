package com.bcsw

class Rep {
    String name
    String party
    String congress
    Integer district
    String state
    String repEmail
    String street
    String phone
    Integer congStart
    Integer congEnd
    Integer congNumStart
    Integer congNumEnd





    static constraints = {
        name()
        party()
        district()
        congress inList: ["House", "Senate"]
        state inList: ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming']
        party inList: ["Republican", "Democrat"]
        repEmail email: true
        street()
        phone()
        congStart()
        congEnd()
        congNumStart()
        congNumEnd()

    }

    String toString() {
        name
    }
}
