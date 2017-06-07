/**
 * Generated by Scrooge
 *   version: 4.16.0-SNAPSHOT
 *   rev: eb110c820bcd2734b26023f24d636bf6d37511b3
 *   built at: 20170607-185808
 */
package parquet.format

import com.twitter.io.Buf
import com.twitter.scrooge.{
  HasThriftStructCodec3,
  LazyTProtocol,
  TFieldBlob,
  ThriftException,
  ThriftStruct,
  ThriftStructCodec3,
  ThriftStructFieldInfo,
  ThriftStructMetaData,
  ThriftUtil
}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.{TMemoryBuffer, TTransport, TIOStreamTransport}
import java.io.ByteArrayInputStream
import java.nio.ByteBuffer
import java.util.Arrays
import java.util.concurrent.atomic.AtomicInteger
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer,
  HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.collection.{Map, Set}

/**
 * Wrapper struct to store key values
 */
object KeyValue extends ThriftStructCodec3[KeyValue] {
  val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("KeyValue")
  val KeyField = new TField("key", TType.STRING, 1)
  val KeyFieldManifest = implicitly[Manifest[String]]
  val ValueField = new TField("value", TType.STRING, 2)
  val ValueFieldManifest = implicitly[Manifest[String]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      KeyField,
      false,
      true,
      KeyFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      ValueField,
      true,
      false,
      ValueFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map.empty[String, String]

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: KeyValue): Unit = {
    if (_item.key == null) throw new TProtocolException("Required field key cannot be null")
  }

  def withoutPassthroughFields(original: KeyValue): KeyValue =
    new Immutable(
      key =
        {
          val field = original.key
          field
        },
      value =
        {
          val field = original.value
          field.map { field =>
            field
          }
        }
    )

  override def encode(_item: KeyValue, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }


  private[this] def lazyDecode(_iprot: LazyTProtocol): KeyValue = {

    var keyOffset: Int = -1
    var _got_key = false
    var valueOffset: Int = -1

    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false
    val _start_offset = _iprot.offset

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.STRING =>
                keyOffset = _iprot.offsetSkipString
    
                _got_key = true
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'key' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRING =>
                valueOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'value' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    if (!_got_key) throw new TProtocolException("Required field 'key' was not found in serialized data for struct KeyValue")
    new LazyImmutable(
      _iprot,
      _iprot.buffer,
      _start_offset,
      _iprot.offset,
      keyOffset,
      valueOffset,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): KeyValue =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[format] def eagerDecode(_iprot: TProtocol): KeyValue = {
    var key: String = null
    var _got_key = false
    var value: _root_.scala.Option[String] = _root_.scala.None
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.STRING =>
                key = readKeyValue(_iprot)
                _got_key = true
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'key' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRING =>
                value = _root_.scala.Some(readValueValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'value' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    if (!_got_key) throw new TProtocolException("Required field 'key' was not found in serialized data for struct KeyValue")
    new Immutable(
      key,
      value,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    key: String,
    value: _root_.scala.Option[String] = _root_.scala.None
  ): KeyValue =
    new Immutable(
      key,
      value
    )

  def unapply(_item: KeyValue): _root_.scala.Option[_root_.scala.Tuple2[String, Option[String]]] = _root_.scala.Some(_item.toTuple)


  @inline private[format] def readKeyValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeKeyField(key_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(KeyField)
    writeKeyValue(key_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeKeyValue(key_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(key_item)
  }

  @inline private[format] def readValueValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeValueField(value_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(ValueField)
    writeValueValue(value_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeValueValue(value_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(value_item)
  }


  object Immutable extends ThriftStructCodec3[KeyValue] {
    override def encode(_item: KeyValue, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): KeyValue = KeyValue.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[KeyValue] = KeyValue.metaData
  }

  /**
   * The default read-only implementation of KeyValue.  You typically should not need to
   * directly reference this class; instead, use the KeyValue.apply method to construct
   * new instances.
   */
  class Immutable(
      val key: String,
      val value: _root_.scala.Option[String],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends KeyValue {
    def this(
      key: String,
      value: _root_.scala.Option[String] = _root_.scala.None
    ) = this(
      key,
      value,
      Map.empty
    )
  }

  /**
   * This is another Immutable, this however keeps strings as lazy values that are lazily decoded from the backing
   * array byte on read.
   */
  private[this] class LazyImmutable(
      _proto: LazyTProtocol,
      _buf: Array[Byte],
      _start_offset: Int,
      _end_offset: Int,
      keyOffset: Int,
      valueOffset: Int,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends KeyValue {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
    }

    lazy val key: String =
      if (keyOffset == -1)
        null
      else {
        _proto.decodeString(_buf, keyOffset)
      }
    lazy val value: _root_.scala.Option[String] =
      if (valueOffset == -1)
        None
      else {
        Some(_proto.decodeString(_buf, valueOffset))
      }

    /**
     * Override the super hash code to make it a lazy val rather than def.
     *
     * Calculating the hash code can be expensive, caching it where possible
     * can provide significant performance wins. (Key in a hash map for instance)
     * Usually not safe since the normal constructor will accept a mutable map or
     * set as an arg
     * Here however we control how the class is generated from serialized data.
     * With the class private and the contract that we throw away our mutable references
     * having the hash code lazy here is safe.
     */
    override lazy val hashCode = super.hashCode
  }

  /**
   * This Proxy trait allows you to extend the KeyValue trait with additional state or
   * behavior and implement the read-only methods from KeyValue using an underlying
   * instance.
   */
  trait Proxy extends KeyValue {
    protected def _underlying_KeyValue: KeyValue
    override def key: String = _underlying_KeyValue.key
    override def value: _root_.scala.Option[String] = _underlying_KeyValue.value
    override def _passthroughFields = _underlying_KeyValue._passthroughFields
  }
}

/**
 * Prefer the companion object's [[parquet.format.KeyValue.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait KeyValue
  extends ThriftStruct
  with _root_.scala.Product2[String, Option[String]]
  with HasThriftStructCodec3[KeyValue]
  with java.io.Serializable
{
  import KeyValue._

  def key: String
  def value: _root_.scala.Option[String]

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = key
  def _2 = value

  def toTuple: _root_.scala.Tuple2[String, Option[String]] = {
    (
      key,
      value
    )
  }


  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
    lazy val _buff = new TMemoryBuffer(32)
    lazy val _oprot = new TCompactProtocol(_buff)
    _passthroughFields.get(_fieldId) match {
      case blob: _root_.scala.Some[TFieldBlob] => blob
      case _root_.scala.None => {
        val _fieldOpt: _root_.scala.Option[TField] =
          _fieldId match {
            case 1 =>
              if (key ne null) {
                writeKeyValue(key, _oprot)
                _root_.scala.Some(KeyValue.KeyField)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (value.isDefined) {
                writeValueValue(value.get, _oprot)
                _root_.scala.Some(KeyValue.ValueField)
              } else {
                _root_.scala.None
              }
            case _ => _root_.scala.None
          }
        _fieldOpt match {
          case _root_.scala.Some(_field) =>
            _root_.scala.Some(TFieldBlob(_field, Buf.ByteArray.Owned(_buff.getArray())))
          case _root_.scala.None =>
            _root_.scala.None
        }
      }
    }
  }

  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids flatMap { id => getFieldBlob(id) map { id -> _ } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): KeyValue = {
    var key: String = this.key
    var value: _root_.scala.Option[String] = this.value
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        key = readKeyValue(_blob.read)
      case 2 =>
        value = _root_.scala.Some(readValueValue(_blob.read))
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      key,
      value,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): KeyValue = {
    var key: String = this.key
    var value: _root_.scala.Option[String] = this.value

    _fieldId match {
      case 1 =>
        key = null
      case 2 =>
        value = _root_.scala.None
      case _ =>
    }
    new Immutable(
      key,
      value,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetKey: KeyValue = unsetField(1)

  def unsetValue: KeyValue = unsetField(2)


  override def write(_oprot: TProtocol): Unit = {
    KeyValue.validate(this)
    _oprot.writeStructBegin(Struct)
    if (key ne null) writeKeyField(key, _oprot)
    if (value.isDefined) writeValueField(value.get, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    key: String = this.key,
    value: _root_.scala.Option[String] = this.value,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): KeyValue =
    new Immutable(
      key,
      value,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[KeyValue]

  private def _equals(x: KeyValue, y: KeyValue): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator)

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[KeyValue]) &&
      _passthroughFields == other.asInstanceOf[KeyValue]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 2

  override def productElement(n: Int): Any = n match {
    case 0 => this.key
    case 1 => this.value
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "KeyValue"

  def _codec: ThriftStructCodec3[KeyValue] = KeyValue
}
