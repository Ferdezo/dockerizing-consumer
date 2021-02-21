package pl.ferdezo.dockerizingconsumer.discount;

import java.util.function.Predicate;

import pl.ferdezo.dockerizingconsumer.model.Discount;

public interface DiscountVerifier extends Predicate<Discount> {}
