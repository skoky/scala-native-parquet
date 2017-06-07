/**
 * Generated by Scrooge
 *   version: 4.16.0-SNAPSHOT
 *   rev: eb110c820bcd2734b26023f24d636bf6d37511b3
 *   built at: 20170607-185808
 */
package parquet.format

import com.twitter.scrooge.ThriftEnum
import scala.collection.immutable.{Map => immutable$Map}

/**
 * Representation of Schemas
 */
@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
case object FieldRepetitionType {

  val annotations: immutable$Map[String, String] = immutable$Map.empty

  /** This field is required (can not be null) and each record has exactly 1 value. */
  case object Required extends parquet.format.FieldRepetitionType {
    val value: Int = 0
    val name: String = "Required"
    val originalName: String = "REQUIRED"
    val annotations: immutable$Map[String, String] = immutable$Map.empty
  }

  private[this] val _SomeRequired = _root_.scala.Some(parquet.format.FieldRepetitionType.Required)
  /** The field is optional (can be null) and each record has 0 or 1 values. */
  case object Optional extends parquet.format.FieldRepetitionType {
    val value: Int = 1
    val name: String = "Optional"
    val originalName: String = "OPTIONAL"
    val annotations: immutable$Map[String, String] = immutable$Map.empty
  }

  private[this] val _SomeOptional = _root_.scala.Some(parquet.format.FieldRepetitionType.Optional)
  /** The field is repeated and can contain 0 or more values */
  case object Repeated extends parquet.format.FieldRepetitionType {
    val value: Int = 2
    val name: String = "Repeated"
    val originalName: String = "REPEATED"
    val annotations: immutable$Map[String, String] = immutable$Map.empty
  }

  private[this] val _SomeRepeated = _root_.scala.Some(parquet.format.FieldRepetitionType.Repeated)

  case class EnumUnknownFieldRepetitionType(value: Int) extends parquet.format.FieldRepetitionType {
    val name: String = "EnumUnknownFieldRepetitionType" + value
    def originalName: String = name
  }

  /**
   * Find the enum by its integer value, as defined in the Thrift IDL.
   */
  def apply(value: Int): parquet.format.FieldRepetitionType =
    value match {
      case 0 => parquet.format.FieldRepetitionType.Required
      case 1 => parquet.format.FieldRepetitionType.Optional
      case 2 => parquet.format.FieldRepetitionType.Repeated
      case _ => throw new NoSuchElementException(value.toString)
    }

  /**
   * Find the enum by its integer value, as defined in the Thrift IDL.
   * returns an EnumUnknownFieldRepetitionType(value) if the value is not found.
   * In particular this allows ignoring new values added to an enum
   * in the IDL on the producer side when the consumer was not updated.
   */
  def getOrUnknown(value: Int): parquet.format.FieldRepetitionType =
    get(value) match {
      case _root_.scala.Some(e) => e
      case _root_.scala.None => EnumUnknownFieldRepetitionType(value)
    }

  /**
   * Find the enum by its integer value, as defined in the Thrift IDL.
   * Returns None if the value is not found
   */
  def get(value: Int): _root_.scala.Option[parquet.format.FieldRepetitionType] =
    value match {
      case 0 => _SomeRequired
      case 1 => _SomeOptional
      case 2 => _SomeRepeated
      case _ => _root_.scala.None
    }

  def valueOf(name: String): _root_.scala.Option[parquet.format.FieldRepetitionType] =
    name.toLowerCase match {
      case "required" => _SomeRequired
      case "optional" => _SomeOptional
      case "repeated" => _SomeRepeated
      case _ => _root_.scala.None
    }

  lazy val list: List[parquet.format.FieldRepetitionType] = scala.List[parquet.format.FieldRepetitionType](
    parquet.format.FieldRepetitionType.Required,
    parquet.format.FieldRepetitionType.Optional,
    parquet.format.FieldRepetitionType.Repeated
  )
}


/**
 * Representation of Schemas
 */
@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
sealed trait FieldRepetitionType extends ThriftEnum with Serializable