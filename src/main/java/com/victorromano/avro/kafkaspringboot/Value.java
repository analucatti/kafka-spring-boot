/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.victorromano.avro.kafkaspringboot;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Value extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 3035005616266974918L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Value\",\"namespace\":\"com.victorromano.avro.kafkaspringboot\",\"fields\":[{\"name\":\"message\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Some random value\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Value> ENCODER =
      new BinaryMessageEncoder<Value>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Value> DECODER =
      new BinaryMessageDecoder<Value>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Value> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Value> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Value> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Value>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Value to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Value from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Value instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Value fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Some random value */
  private java.lang.String message;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Value() {}

  /**
   * All-args constructor.
   * @param message Some random value
   */
  public Value(java.lang.String message) {
    this.message = message;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return message;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: message = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'message' field.
   * @return Some random value
   */
  public java.lang.String getMessage() {
    return message;
  }



  /**
   * Creates a new Value RecordBuilder.
   * @return A new Value RecordBuilder
   */
  public static com.victorromano.avro.kafkaspringboot.Value.Builder newBuilder() {
    return new com.victorromano.avro.kafkaspringboot.Value.Builder();
  }

  /**
   * Creates a new Value RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Value RecordBuilder
   */
  public static com.victorromano.avro.kafkaspringboot.Value.Builder newBuilder(com.victorromano.avro.kafkaspringboot.Value.Builder other) {
    if (other == null) {
      return new com.victorromano.avro.kafkaspringboot.Value.Builder();
    } else {
      return new com.victorromano.avro.kafkaspringboot.Value.Builder(other);
    }
  }

  /**
   * Creates a new Value RecordBuilder by copying an existing Value instance.
   * @param other The existing instance to copy.
   * @return A new Value RecordBuilder
   */
  public static com.victorromano.avro.kafkaspringboot.Value.Builder newBuilder(com.victorromano.avro.kafkaspringboot.Value other) {
    if (other == null) {
      return new com.victorromano.avro.kafkaspringboot.Value.Builder();
    } else {
      return new com.victorromano.avro.kafkaspringboot.Value.Builder(other);
    }
  }

  /**
   * RecordBuilder for Value instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Value>
    implements org.apache.avro.data.RecordBuilder<Value> {

    /** Some random value */
    private java.lang.String message;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.victorromano.avro.kafkaspringboot.Value.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.message)) {
        this.message = data().deepCopy(fields()[0].schema(), other.message);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing Value instance
     * @param other The existing instance to copy.
     */
    private Builder(com.victorromano.avro.kafkaspringboot.Value other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.message)) {
        this.message = data().deepCopy(fields()[0].schema(), other.message);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'message' field.
      * Some random value
      * @return The value.
      */
    public java.lang.String getMessage() {
      return message;
    }


    /**
      * Sets the value of the 'message' field.
      * Some random value
      * @param value The value of 'message'.
      * @return This builder.
      */
    public com.victorromano.avro.kafkaspringboot.Value.Builder setMessage(java.lang.String value) {
      validate(fields()[0], value);
      this.message = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'message' field has been set.
      * Some random value
      * @return True if the 'message' field has been set, false otherwise.
      */
    public boolean hasMessage() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'message' field.
      * Some random value
      * @return This builder.
      */
    public com.victorromano.avro.kafkaspringboot.Value.Builder clearMessage() {
      message = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Value build() {
      try {
        Value record = new Value();
        record.message = fieldSetFlags()[0] ? this.message : (java.lang.String) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Value>
    WRITER$ = (org.apache.avro.io.DatumWriter<Value>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Value>
    READER$ = (org.apache.avro.io.DatumReader<Value>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.message);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.message = in.readString();

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.message = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










