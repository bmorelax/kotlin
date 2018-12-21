// !LANGUAGE: +NewInference
// !DIAGNOSTICS: -UNUSED_EXPRESSION
// SKIP_TXT

/*
 * KOTLIN DIAGNOSTICS SPEC TEST (POSITIVE)
 *
 * SPEC VERSION: 0.1-draft
 * PLACE: type-inference, smart-casts, smart-casts-sources -> paragraph 6 -> sentence 1
 * NUMBER: 5
 * DESCRIPTION: Multi smartcasts
 * UNEXPECTED BEHAVIOUR
 * HELPERS: classes, interfaces
 */

// TESTCASE NUMBER: 1
fun case_1(x: Any?) {
    if (x is Number?) {
        if (x !== null) {
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Number")!>x<!>
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
        }
    }
}

// TESTCASE NUMBER: 2
fun case_2(x: Any?) {
    if (x is Number? && x is Int? && x != null) {
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number")!>x<!>
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
    }
}

// TESTCASE NUMBER: 3
fun case_3(x: Any?) {
    if (x is Number?) {
        if (x !== null) {
            if (x is Int?) {
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number")!>x<!>
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
            }
        }
    }
}

// TESTCASE NUMBER: 4
fun case_4(x: Any?) {
    if (x != null) {
        if (x is Number) {
            if (x is Int?) {
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number")!>x<!>
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
            }
        }
    }
}

// TESTCASE NUMBER: 5
fun case_5(x: Any?) {
    if (x is _ClassLevel1?) {
        if (x is _ClassLevel2?) {
            if (x is _ClassLevel3?) {
                if (x is _ClassLevel4?) {
                    if (x is _ClassLevel5?) {
                        if (x != null) {
                            <!DEBUG_INFO_EXPRESSION_TYPE("_ClassLevel1 & _ClassLevel2 & _ClassLevel3 & _ClassLevel4 & _ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
                            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
                            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
                            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel2"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
                            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel3"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
                            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel4"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
                            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel5"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
                        }
                    }
                }
            }
        }
    }
}

// TESTCASE NUMBER: 6
fun case_6(x: Any?) {
    if (x is _ClassLevel1?) {
        if (x is _ClassLevel2?) {
            if (x is _ClassLevel3?) {
                if (x != null && x is _ClassLevel4?) {
                    if (x is _ClassLevel5?) {
                        <!DEBUG_INFO_EXPRESSION_TYPE("_ClassLevel1 & _ClassLevel2 & _ClassLevel3 & _ClassLevel4 & _ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel2"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel3"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel4"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel5"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
                    }
                }
            }
        }
    }
}

// TESTCASE NUMBER: 7
fun case_7(x: Any?) {
    if (x is _ClassLevel1? && x is _ClassLevel2? && x is _ClassLevel3?) {
        if (x is _ClassLevel4? && x != null && x is _ClassLevel5?) {
            <!DEBUG_INFO_EXPRESSION_TYPE("_ClassLevel1 & _ClassLevel2 & _ClassLevel3 & _ClassLevel4 & _ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel2"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel3"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel4"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel5"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
        }
    }
}

// TESTCASE NUMBER: 8
fun case_8(x: Any?) {
    if (x is _ClassLevel1? && x is _ClassLevel2? && x is _ClassLevel3?) {
        if (x is _ClassLevel4? && x != null && x is _ClassLevel5?) {
            <!DEBUG_INFO_EXPRESSION_TYPE("_ClassLevel1 & _ClassLevel2 & _ClassLevel3 & _ClassLevel4 & _ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel2"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel3"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel4"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel5"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
        }
    }
}

// TESTCASE NUMBER: 9
fun case_9(x: Any?) {
    if (x is _ClassLevel1? && x is _ClassLevel2? && x is _ClassLevel3? && x is _ClassLevel4? && x != null && x is _ClassLevel5?) {
        <!DEBUG_INFO_EXPRESSION_TYPE("_ClassLevel1 & _ClassLevel2 & _ClassLevel3 & _ClassLevel4 & _ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel2"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel3"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel4"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel5"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
    }
}

// TESTCASE NUMBER: 10
fun case_10(x: Any?) {
    if (x is _ClassLevel1? && x is _ClassLevel2? && x is _ClassLevel3?) {
        if (x is _ClassLevel4?) {

        } else if (x is _ClassLevel5? && x != null) {
            <!DEBUG_INFO_EXPRESSION_TYPE("_ClassLevel1 & _ClassLevel2 & _ClassLevel3 & _ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel2"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel3"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel5"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel5"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
        }
    } else if (x is _ClassLevel4? && x != null && x is _ClassLevel5?) {
        <!DEBUG_INFO_EXPRESSION_TYPE("_ClassLevel4 & _ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel4"), DEBUG_INFO_SMARTCAST!>x<!>.equals(x)
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel4"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel4"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel4"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel4"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel5"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
    }
}

/*
 * TESTCASE NUMBER: 11
 * NOTE: lazy smartcasts
 * DISCUSSION
 * ISSUES: KT-28362
 */
fun case_11(x: Any?) {
    if (x is _Interface1?) {
        if (x is _Interface2?) {
            if (x != null) {
                <!DEBUG_INFO_EXPRESSION_TYPE("_Interface1 & _Interface2 & kotlin.Any & kotlin.Any?")!>x<!>
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _Interface1"), DEBUG_INFO_SMARTCAST!>x<!>.itest1()
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _Interface2"), DEBUG_INFO_SMARTCAST!>x<!>.itest2()

                <!DEBUG_INFO_EXPRESSION_TYPE("_Interface1 & _Interface2 & kotlin.Any & kotlin.Any?")!>x<!>.let { <!DEBUG_INFO_EXPRESSION_TYPE("{Any & _Interface1 & _Interface2}")!>it<!>.itest1(); <!DEBUG_INFO_EXPRESSION_TYPE("{Any & _Interface1 & _Interface2}")!>it<!>.itest2() }
            }
        }
    }
}

/*
 * TESTCASE NUMBER: 12
 * NOTE: lazy smartcasts
 * DISCUSSION
 * ISSUES: KT-28362
 */
fun case_12(x: Any?) {
    if (x is _Interface1? && x != null && x is _Interface2?) {
        <!DEBUG_INFO_EXPRESSION_TYPE("_Interface1 & _Interface2 & kotlin.Any & kotlin.Any?")!>x<!>
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _Interface1"), DEBUG_INFO_SMARTCAST!>x<!>.itest1()
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _Interface2"), DEBUG_INFO_SMARTCAST!>x<!>.itest2()

        <!DEBUG_INFO_EXPRESSION_TYPE("_Interface1 & _Interface2 & kotlin.Any & kotlin.Any?")!>x<!>.let { <!DEBUG_INFO_EXPRESSION_TYPE("{Any & _Interface1 & _Interface2}")!>it<!>.itest1(); <!DEBUG_INFO_EXPRESSION_TYPE("{Any & _Interface1 & _Interface2}")!>it<!>.itest2() }
    }
}

/*
 * TESTCASE NUMBER: 13
 * NOTE: lazy smartcasts
 * DISCUSSION
 * ISSUES: KT-28362
 */
fun case_13(x: Any?) {
    if (x is _Interface2?) {
        if (x is _ClassLevel1?) {
            if (x is _ClassLevel2? && x is _Interface1?) {
                if (x !is _Interface3?) {} else if (false) {
                    if (x != null) {
                        <!DEBUG_INFO_EXPRESSION_TYPE("_ClassLevel1 & _ClassLevel2 & _Interface1 & _Interface2 & _Interface3 & kotlin.Any & kotlin.Any?")!>x<!>
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _Interface1"), DEBUG_INFO_SMARTCAST!>x<!>.itest1()
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _Interface2"), DEBUG_INFO_SMARTCAST!>x<!>.itest2()
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _Interface3"), DEBUG_INFO_SMARTCAST!>x<!>.itest3()
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel2"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
                    }
                }
            }
        }
    }
}

/*
 * TESTCASE NUMBER: 14
 * NOTE: lazy smartcasts
 * DISCUSSION
 * ISSUES: KT-28362
 */
fun case_14(x: Any?) {
    if (x is _Interface2?) {
        if (x is _ClassLevel1?) {
            if (x == null || x !is _Interface1?) else {
                if (x is _ClassLevel2?) {
                    if (x is _Interface3?) {
                        <!DEBUG_INFO_EXPRESSION_TYPE("_ClassLevel1 & _ClassLevel2 & _Interface1 & _Interface2 & _Interface3 & kotlin.Any & kotlin.Any?")!>x<!>
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _Interface1"), DEBUG_INFO_SMARTCAST!>x<!>.itest1()
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _Interface2"), DEBUG_INFO_SMARTCAST!>x<!>.itest2()
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _Interface3"), DEBUG_INFO_SMARTCAST!>x<!>.itest3()
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel1"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
                        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel2"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
                    }
                }
            }
        }
    }
}

/*
 * TESTCASE NUMBER: 15
 * NOTE: lazy smartcasts
 * DISCUSSION
 * ISSUES: KT-28362
 */
fun case_15(x: Any?) {
    if (x !is _ClassLevel2? || <!USELESS_IS_CHECK!>x !is _ClassLevel1?<!>) else {
        if (x === null || x !is _Interface1?) else {
            if (x !is _Interface2? || x !is _Interface3?) {} else {
                <!DEBUG_INFO_EXPRESSION_TYPE("_ClassLevel1 & _ClassLevel2 & _Interface1 & _Interface2 & _Interface3 & kotlin.Any & kotlin.Any?")!>x<!>
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _Interface2"), DEBUG_INFO_SMARTCAST!>x<!>.itest2()
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _Interface1"), DEBUG_INFO_SMARTCAST!>x<!>.itest1()
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _Interface3"), DEBUG_INFO_SMARTCAST!>x<!>.itest3()
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel2"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & _ClassLevel2"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
            }
        }
    }
}

// TESTCASE NUMBER: 16
fun case_16(a: Any?, b: Int = if (a is Number? && a is Int? && a !== null) <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number"), DEBUG_INFO_SMARTCAST!>a<!> else 0) {
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any?")!>a<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.equals(b)
}

// TESTCASE NUMBER: 17
fun case_17(a: Any?, b: Int = if (a !is Number? || a !is Int? || a == null) 0 else <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number"), DEBUG_INFO_SMARTCAST!>a<!>) {
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any?")!>a<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.equals(b)
}
