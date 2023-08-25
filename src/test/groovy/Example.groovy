import spock.lang.Specification
import spock.lang.Unroll

class Example extends Specification {

    @Unroll("maximum of #a and #b is #c")
    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c
        where:
        a | b | c
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0
    }

}
