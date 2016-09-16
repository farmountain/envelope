package com.cloudera.labs.envelope.translate;

import java.util.Properties;
import org.apache.avro.Schema;
import static org.junit.Assert.assertSame;
import org.junit.Test;

/**
 *
 */
public class TranslatorTest {

  @Test
  public void translatorFor() throws Exception {
    Properties props = new Properties();
    props.setProperty("translator", FauxTranslator.class.getName());

    Translator first = Translator.translatorFor(props);

    assertSame("Translator not reused", Translator.translatorFor(props), first);
  }

}

class FauxTranslator extends Translator {

  public FauxTranslator(Properties properties) {
    super(properties);
  }

  /**
   * @return The Avro schema for the records that the translator generates.
   */
  @Override
  public Schema getSchema() {
    return null;
  }
}