package pl.ferdezo.dockerizingconsumer.discount;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import pl.ferdezo.dockerizingconsumer.model.Discount;

class ProfitableDiscountVerifierTest {

	ProfitableDiscountVerifier discountVerifier = new ProfitableDiscountVerifier(0.2);

	@Test
	void shouldAcceptVeryProfitableDiscount() {
		// given
		var profitableDiscount = Discount.builder()
				.oldPrice(BigDecimal.valueOf(100))
				.price(BigDecimal.valueOf(70))
				.build();

		// when
		boolean isProfitable = discountVerifier.test(profitableDiscount);

		// then
		assertTrue(isProfitable);
	}

	@Test
	void shouldAcceptProfitableDiscount() {
		// given
		var profitableDiscount = Discount.builder()
				.oldPrice(BigDecimal.valueOf(100))
				.price(BigDecimal.valueOf(80))
				.build();

		// when
		boolean isProfitable = discountVerifier.test(profitableDiscount);

		// then
		assertTrue(isProfitable);
	}

	@Test
	void shouldNotAcceptNotProfitableDiscount() {
		// given
		var profitableDiscount = Discount.builder()
				.oldPrice(BigDecimal.valueOf(100))
				.price(BigDecimal.valueOf(90))
				.build();

		// when
		boolean isProfitable = discountVerifier.test(profitableDiscount);

		// then
		assertTrue(isProfitable);

	}

	@Test
	void shouldNotAcceptUnchangedPrice() {
		// given
		var profitableDiscount = Discount.builder()
				.oldPrice(BigDecimal.valueOf(100))
				.price(BigDecimal.valueOf(100))
				.build();

		// when
		boolean isProfitable = discountVerifier.test(profitableDiscount);

		// then
		assertTrue(isProfitable);
	}

	@Test
	void shouldNotAcceptIncreasedPrice() {
		// given
		var profitableDiscount = Discount.builder()
				.oldPrice(BigDecimal.valueOf(100))
				.price(BigDecimal.valueOf(110))
				.build();

		// when
		boolean isProfitable = discountVerifier.test(profitableDiscount);

		// then
		assertTrue(isProfitable);
	}
}