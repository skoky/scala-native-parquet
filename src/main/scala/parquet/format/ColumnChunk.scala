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


object ColumnChunk extends ThriftStructCodec3[ColumnChunk] {
  val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("ColumnChunk")
  val FilePathField = new TField("file_path", TType.STRING, 1)
  val FilePathFieldManifest = implicitly[Manifest[String]]
  val FileOffsetField = new TField("file_offset", TType.I64, 2)
  val FileOffsetFieldManifest = implicitly[Manifest[Long]]
  val MetaDataField = new TField("meta_data", TType.STRUCT, 3)
  val MetaDataFieldManifest = implicitly[Manifest[parquet.format.ColumnMetaData]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      FilePathField,
      true,
      false,
      FilePathFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      FileOffsetField,
      false,
      true,
      FileOffsetFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      MetaDataField,
      true,
      false,
      MetaDataFieldManifest,
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
  def validate(_item: ColumnChunk): Unit = {
  }

  def withoutPassthroughFields(original: ColumnChunk): ColumnChunk =
    new Immutable(
      filePath =
        {
          val field = original.filePath
          field.map { field =>
            field
          }
        },
      fileOffset =
        {
          val field = original.fileOffset
          field
        },
      metaData =
        {
          val field = original.metaData
          field.map { field =>
            parquet.format.ColumnMetaData.withoutPassthroughFields(field)
          }
        }
    )

  override def encode(_item: ColumnChunk, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }


  private[this] def lazyDecode(_iprot: LazyTProtocol): ColumnChunk = {

    var file_pathOffset: Int = -1
    var fileOffset: Long = 0L
    var _got_fileOffset = false
    var metaData: Option[parquet.format.ColumnMetaData] = None

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
                file_pathOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'filePath' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.I64 =>
    
                fileOffset = readFileOffsetValue(_iprot)
                _got_fileOffset = true
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'fileOffset' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRUCT =>
    
                metaData = Some(readMetaDataValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'metaData' (expected=%s, actual=%s).".format(
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

    if (!_got_fileOffset) throw new TProtocolException("Required field 'fileOffset' was not found in serialized data for struct ColumnChunk")
    new LazyImmutable(
      _iprot,
      _iprot.buffer,
      _start_offset,
      _iprot.offset,
      file_pathOffset,
      fileOffset,
      metaData,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): ColumnChunk =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[format] def eagerDecode(_iprot: TProtocol): ColumnChunk = {
    var filePath: _root_.scala.Option[String] = _root_.scala.None
    var fileOffset: Long = 0L
    var _got_fileOffset = false
    var metaData: _root_.scala.Option[parquet.format.ColumnMetaData] = _root_.scala.None
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
                filePath = _root_.scala.Some(readFilePathValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'filePath' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.I64 =>
                fileOffset = readFileOffsetValue(_iprot)
                _got_fileOffset = true
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'fileOffset' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRUCT =>
                metaData = _root_.scala.Some(readMetaDataValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'metaData' (expected=%s, actual=%s).".format(
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

    if (!_got_fileOffset) throw new TProtocolException("Required field 'fileOffset' was not found in serialized data for struct ColumnChunk")
    new Immutable(
      filePath,
      fileOffset,
      metaData,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    filePath: _root_.scala.Option[String] = _root_.scala.None,
    fileOffset: Long,
    metaData: _root_.scala.Option[parquet.format.ColumnMetaData] = _root_.scala.None
  ): ColumnChunk =
    new Immutable(
      filePath,
      fileOffset,
      metaData
    )

  def unapply(_item: ColumnChunk): _root_.scala.Option[_root_.scala.Tuple3[Option[String], Long, Option[parquet.format.ColumnMetaData]]] = _root_.scala.Some(_item.toTuple)


  @inline private[format] def readFilePathValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeFilePathField(filePath_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(FilePathField)
    writeFilePathValue(filePath_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeFilePathValue(filePath_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(filePath_item)
  }

  @inline private[format] def readFileOffsetValue(_iprot: TProtocol): Long = {
    _iprot.readI64()
  }

  @inline private def writeFileOffsetField(fileOffset_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(FileOffsetField)
    writeFileOffsetValue(fileOffset_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeFileOffsetValue(fileOffset_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeI64(fileOffset_item)
  }

  @inline private[format] def readMetaDataValue(_iprot: TProtocol): parquet.format.ColumnMetaData = {
    parquet.format.ColumnMetaData.decode(_iprot)
  }

  @inline private def writeMetaDataField(metaData_item: parquet.format.ColumnMetaData, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(MetaDataField)
    writeMetaDataValue(metaData_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeMetaDataValue(metaData_item: parquet.format.ColumnMetaData, _oprot: TProtocol): Unit = {
    metaData_item.write(_oprot)
  }


  object Immutable extends ThriftStructCodec3[ColumnChunk] {
    override def encode(_item: ColumnChunk, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): ColumnChunk = ColumnChunk.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[ColumnChunk] = ColumnChunk.metaData
  }

  /**
   * The default read-only implementation of ColumnChunk.  You typically should not need to
   * directly reference this class; instead, use the ColumnChunk.apply method to construct
   * new instances.
   */
  class Immutable(
      val filePath: _root_.scala.Option[String],
      val fileOffset: Long,
      val metaData: _root_.scala.Option[parquet.format.ColumnMetaData],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends ColumnChunk {
    def this(
      filePath: _root_.scala.Option[String] = _root_.scala.None,
      fileOffset: Long,
      metaData: _root_.scala.Option[parquet.format.ColumnMetaData] = _root_.scala.None
    ) = this(
      filePath,
      fileOffset,
      metaData,
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
      file_pathOffset: Int,
      val fileOffset: Long,
      val metaData: _root_.scala.Option[parquet.format.ColumnMetaData],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends ColumnChunk {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
    }

    lazy val filePath: _root_.scala.Option[String] =
      if (file_pathOffset == -1)
        None
      else {
        Some(_proto.decodeString(_buf, file_pathOffset))
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
   * This Proxy trait allows you to extend the ColumnChunk trait with additional state or
   * behavior and implement the read-only methods from ColumnChunk using an underlying
   * instance.
   */
  trait Proxy extends ColumnChunk {
    protected def _underlying_ColumnChunk: ColumnChunk
    override def filePath: _root_.scala.Option[String] = _underlying_ColumnChunk.filePath
    override def fileOffset: Long = _underlying_ColumnChunk.fileOffset
    override def metaData: _root_.scala.Option[parquet.format.ColumnMetaData] = _underlying_ColumnChunk.metaData
    override def _passthroughFields = _underlying_ColumnChunk._passthroughFields
  }
}

/**
 * Prefer the companion object's [[parquet.format.ColumnChunk.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait ColumnChunk
  extends ThriftStruct
  with _root_.scala.Product3[Option[String], Long, Option[parquet.format.ColumnMetaData]]
  with HasThriftStructCodec3[ColumnChunk]
  with java.io.Serializable
{
  import ColumnChunk._

  def filePath: _root_.scala.Option[String]
  def fileOffset: Long
  def metaData: _root_.scala.Option[parquet.format.ColumnMetaData]

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = filePath
  def _2 = fileOffset
  def _3 = metaData

  def toTuple: _root_.scala.Tuple3[Option[String], Long, Option[parquet.format.ColumnMetaData]] = {
    (
      filePath,
      fileOffset,
      metaData
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
              if (filePath.isDefined) {
                writeFilePathValue(filePath.get, _oprot)
                _root_.scala.Some(ColumnChunk.FilePathField)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (true) {
                writeFileOffsetValue(fileOffset, _oprot)
                _root_.scala.Some(ColumnChunk.FileOffsetField)
              } else {
                _root_.scala.None
              }
            case 3 =>
              if (metaData.isDefined) {
                writeMetaDataValue(metaData.get, _oprot)
                _root_.scala.Some(ColumnChunk.MetaDataField)
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
  def setField(_blob: TFieldBlob): ColumnChunk = {
    var filePath: _root_.scala.Option[String] = this.filePath
    var fileOffset: Long = this.fileOffset
    var metaData: _root_.scala.Option[parquet.format.ColumnMetaData] = this.metaData
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        filePath = _root_.scala.Some(readFilePathValue(_blob.read))
      case 2 =>
        fileOffset = readFileOffsetValue(_blob.read)
      case 3 =>
        metaData = _root_.scala.Some(readMetaDataValue(_blob.read))
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      filePath,
      fileOffset,
      metaData,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): ColumnChunk = {
    var filePath: _root_.scala.Option[String] = this.filePath
    var fileOffset: Long = this.fileOffset
    var metaData: _root_.scala.Option[parquet.format.ColumnMetaData] = this.metaData

    _fieldId match {
      case 1 =>
        filePath = _root_.scala.None
      case 2 =>
        fileOffset = 0L
      case 3 =>
        metaData = _root_.scala.None
      case _ =>
    }
    new Immutable(
      filePath,
      fileOffset,
      metaData,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetFilePath: ColumnChunk = unsetField(1)

  def unsetFileOffset: ColumnChunk = unsetField(2)

  def unsetMetaData: ColumnChunk = unsetField(3)


  override def write(_oprot: TProtocol): Unit = {
    ColumnChunk.validate(this)
    _oprot.writeStructBegin(Struct)
    if (filePath.isDefined) writeFilePathField(filePath.get, _oprot)
    writeFileOffsetField(fileOffset, _oprot)
    if (metaData.isDefined) writeMetaDataField(metaData.get, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    filePath: _root_.scala.Option[String] = this.filePath,
    fileOffset: Long = this.fileOffset,
    metaData: _root_.scala.Option[parquet.format.ColumnMetaData] = this.metaData,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): ColumnChunk =
    new Immutable(
      filePath,
      fileOffset,
      metaData,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[ColumnChunk]

  private def _equals(x: ColumnChunk, y: ColumnChunk): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator)

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[ColumnChunk]) &&
      _passthroughFields == other.asInstanceOf[ColumnChunk]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 3

  override def productElement(n: Int): Any = n match {
    case 0 => this.filePath
    case 1 => this.fileOffset
    case 2 => this.metaData
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "ColumnChunk"

  def _codec: ThriftStructCodec3[ColumnChunk] = ColumnChunk
}
