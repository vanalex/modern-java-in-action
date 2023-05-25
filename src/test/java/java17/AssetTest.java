package java17;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssetTest {

  @Test
  void testAsset(){
    Asset stock = new Stock("BUG", "Me", 100);
    long result = stock.calculateAssetPrice();
    Assertions.assertEquals(100L, result);

    Asset bond = new Bond("BUG-1", "Me", 102, 0.5f, LocalDate.of(2021, 1, 1), LocalDate.of(2099, 1, 1));
    result = bond.calculateAssetPrice();
    Assertions.assertEquals(570L, result);

    Asset certificationOfDeposit = new CertificateOfDeposit("CD-1", "Me", 200, 0.4f, LocalDate.of(2099, 1, 1), Term.ONE_YEAR);
    result = certificationOfDeposit.calculateAssetPrice();
    Assertions.assertEquals(205L, result);
  }
}
