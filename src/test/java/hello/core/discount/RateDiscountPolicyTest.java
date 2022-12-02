package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 회원 할인")
    void vipDiscount() {
        // given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discount = rateDiscountPolicy.discount(memberVIP, 10000);
        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("일반 회원 할인")
    void notDiscount() {
        // given
        Member memberBasic = new Member(1L, "memberBasic", Grade.BASIC);
        // when
        int discount = rateDiscountPolicy.discount(memberBasic, 10000);
        // then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}