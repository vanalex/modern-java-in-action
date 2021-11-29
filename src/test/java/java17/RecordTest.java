package java17;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class RecordTest {

  @Test
  void testEquals() {
    RecordId recordId01 = new RecordId("r-01");
    RecordId recordId02 = new RecordId("r-02");
    RecordId recordId03 = new RecordId("r-01");
    RecordId recordId04 = new RecordId("r-01");
    //reflective
    assertThat(recordId01).isEqualTo(recordId01);
    //symmetric
    assertThat(recordId01).isEqualTo(recordId03);
    assertThat(recordId03).isEqualTo(recordId01);
    //transitive
    assertThat(recordId01).isEqualTo(recordId03);
    assertThat(recordId03).isEqualTo(recordId04);
    assertThat(recordId03).isEqualTo(recordId01);
    //consistent
    assertThat(recordId01).isEqualTo(recordId01);
    assertThat(recordId01).isEqualTo(recordId03);
    //null
    assertThat(recordId01).isNotEqualTo(null);
    assertThat(recordId02).isNotEqualTo(null);
    assertThat(recordId03).isNotEqualTo(null);
    //negative
    assertThat(recordId01).isNotEqualTo(recordId02);
    assertThat(recordId02).isNotEqualTo(recordId01);
  }

  @Test
  void testHashCode() {
    RecordId recordId01 = new RecordId("r-01");
    RecordId recordId02 = new RecordId("r-02");
    RecordId recordId03 = new RecordId("r-01");
    assertThat(recordId01.hashCode()).hasSameHashCodeAs(recordId01.hashCode());
    assertThat(recordId01.hashCode()).hasSameHashCodeAs(recordId03.hashCode());
    assertThat(recordId01.hashCode()).isNotEqualTo(recordId02.hashCode());
  }

  @Test
  void testToString() {
    RecordId recordId = new RecordId("r-01");
    assertThat(recordId.toString()).isNotNull();
  }

  @Test
  void testRecordId() {
    RecordId recordId = new RecordId("r-01");
    assertThat(recordId.id()).isNotNull();
    assertThat(recordId.id()).isEqualTo("r-01");
  }

}
