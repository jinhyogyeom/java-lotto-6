package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.Quantity;
import lotto.util.LottoGenerator;

public class LottoService {

    private Quantity quantity;
    private Lottos lottos;
    private final LottoGenerator lottoGenerator;

    public LottoService() {
        lottoGenerator = new LottoGenerator();
    }

    public void purchaseLotto(int price) {
        this.quantity = Quantity.of(price);
        this.lottos = lottoGenerator.generate(quantity.getQuantity());
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int getTotalPrice() {
        return quantity.getTotalPrice();
    }
}