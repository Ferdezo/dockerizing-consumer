package pl.ferdezo.dockerizingconsumer.discount;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import pl.ferdezo.dockerizingconsumer.model.Discount;

@Component
public class ProfitableDiscountVerifier implements DiscountVerifier {
	private final double discountPercentage;

	public ProfitableDiscountVerifier(
			@Value("${discount.threshold.percentage}") double discountPercentage
	) {
		this.discountPercentage = discountPercentage;
	}

	@Override
	public boolean test(Discount discount) {
		final BigDecimal oldPrice = discount.getOldPrice();
		final BigDecimal currentPrice = discount.getPrice();

		final BigDecimal priceRatio = currentPrice.divide(oldPrice, RoundingMode.CEILING);
		final BigDecimal acceptableDiscount = BigDecimal.valueOf(discountPercentage);

		return BigDecimal.valueOf(100).subtract(priceRatio).compareTo(acceptableDiscount) >= 0;
	}
}
