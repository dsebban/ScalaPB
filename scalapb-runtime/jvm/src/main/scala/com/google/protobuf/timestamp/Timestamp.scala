// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.google.protobuf.timestamp

/** A Timestamp represents a point in time independent of any time zone or local
  * calendar, encoded as a count of seconds and fractions of seconds at
  * nanosecond resolution. The count is relative to an epoch at UTC midnight on
  * January 1, 1970, in the proleptic Gregorian calendar which extends the
  * Gregorian calendar backwards to year one.
  *
  * All minutes are 60 seconds long. Leap seconds are "smeared" so that no leap
  * second table is needed for interpretation, using a [24-hour linear
  * smear](https://developers.google.com/time/smear).
  *
  * The range is from 0001-01-01T00:00:00Z to 9999-12-31T23:59:59.999999999Z. By
  * restricting to that range, we ensure that we can convert to and from [RFC
  * 3339](https://www.ietf.org/rfc/rfc3339.txt) date strings.
  *
  * # Examples
  *
  * Example 1: Compute Timestamp from POSIX `time()`.
  *
  *     Timestamp timestamp;
  *     timestamp.set_seconds(time(NULL));
  *     timestamp.set_nanos(0);
  *
  * Example 2: Compute Timestamp from POSIX `gettimeofday()`.
  *
  *     struct timeval tv;
  *     gettimeofday(&amp;tv, NULL);
  *
  *     Timestamp timestamp;
  *     timestamp.set_seconds(tv.tv_sec);
  *     timestamp.set_nanos(tv.tv_usec * 1000);
  *
  * Example 3: Compute Timestamp from Win32 `GetSystemTimeAsFileTime()`.
  *
  *     FILETIME ft;
  *     GetSystemTimeAsFileTime(&amp;ft);
  *     UINT64 ticks = (((UINT64)ft.dwHighDateTime) &lt;&lt; 32) | ft.dwLowDateTime;
  *
  *     // A Windows tick is 100 nanoseconds. Windows epoch 1601-01-01T00:00:00Z
  *     // is 11644473600 seconds before Unix epoch 1970-01-01T00:00:00Z.
  *     Timestamp timestamp;
  *     timestamp.set_seconds((INT64) ((ticks / 10000000) - 11644473600LL));
  *     timestamp.set_nanos((INT32) ((ticks % 10000000) * 100));
  *
  * Example 4: Compute Timestamp from Java `System.currentTimeMillis()`.
  *
  *     long millis = System.currentTimeMillis();
  *
  *     Timestamp timestamp = Timestamp.newBuilder().setSeconds(millis / 1000)
  *         .setNanos((int) ((millis % 1000) * 1000000)).build();
  *
  *
  * Example 5: Compute Timestamp from current time in Python.
  *
  *     timestamp = Timestamp()
  *     timestamp.GetCurrentTime()
  *
  * # JSON Mapping
  *
  * In JSON format, the Timestamp type is encoded as a string in the
  * [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt) format. That is, the
  * format is "{year}-{month}-{day}T{hour}:{min}:{sec}[.{frac_sec}]Z"
  * where {year} is always expressed using four digits while {month}, {day},
  * {hour}, {min}, and {sec} are zero-padded to two digits each. The fractional
  * seconds, which can go up to 9 digits (i.e. up to 1 nanosecond resolution),
  * are optional. The "Z" suffix indicates the timezone ("UTC"); the timezone
  * is required. A proto3 JSON serializer should always use UTC (as indicated by
  * "Z") when printing the Timestamp type and a proto3 JSON parser should be
  * able to accept both UTC and other timezones (as indicated by an offset).
  *
  * For example, "2017-01-15T01:30:15.01Z" encodes 15.01 seconds past
  * 01:30 UTC on January 15, 2017.
  *
  * In JavaScript, one can convert a Date object to this format using the
  * standard [toISOString()](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Date/toISOString)
  * method. In Python, a standard `datetime.datetime` object can be converted
  * to this format using [`strftime`](https://docs.python.org/2/library/time.html#time.strftime)
  * with the time format spec '%Y-%m-%dT%H:%M:%S.%fZ'. Likewise, in Java, one
  * can use the Joda Time's [`ISODateTimeFormat.dateTime()`](
  * http://www.joda.org/joda-time/apidocs/org/joda/time/format/ISODateTimeFormat.html#dateTime%2D%2D
  * ) to obtain a formatter capable of generating timestamps in this format.
  *
  * @param seconds
  *   Represents seconds of UTC time since Unix epoch
  *   1970-01-01T00:00:00Z. Must be from 0001-01-01T00:00:00Z to
  *   9999-12-31T23:59:59Z inclusive.
  * @param nanos
  *   Non-negative fractions of a second at nanosecond resolution. Negative
  *   second values with fractions must still have non-negative nanos values
  *   that count forward in time. Must be from 0 to 999,999,999
  *   inclusive.
  */
@SerialVersionUID(0L)
final case class Timestamp(
    seconds: _root_.scala.Long = 0L,
    nanos: _root_.scala.Int = 0,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[Timestamp] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = seconds
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(1, __value)
        }
      };
      
      {
        val __value = nanos
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(2, __value)
        }
      };
      __size += unknownFields.serializedSize
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      {
        val __v = seconds
        if (__v != 0L) {
          _output__.writeInt64(1, __v)
        }
      };
      {
        val __v = nanos
        if (__v != 0) {
          _output__.writeInt32(2, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withSeconds(__v: _root_.scala.Long): Timestamp = copy(seconds = __v)
    def withNanos(__v: _root_.scala.Int): Timestamp = copy(nanos = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = seconds
          if (__t != 0L) __t else null
        }
        case 2 => {
          val __t = nanos
          if (__t != 0) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PLong(seconds)
        case 2 => _root_.scalapb.descriptors.PInt(nanos)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.google.protobuf.timestamp.Timestamp
    // @@protoc_insertion_point(GeneratedMessage[google.protobuf.Timestamp])
}

object Timestamp extends scalapb.GeneratedMessageCompanion[com.google.protobuf.timestamp.Timestamp] with scalapb.JavaProtoSupport[com.google.protobuf.timestamp.Timestamp, com.google.protobuf.Timestamp] with scalapb.TimestampCompanionMethods {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.google.protobuf.timestamp.Timestamp] with scalapb.JavaProtoSupport[com.google.protobuf.timestamp.Timestamp, com.google.protobuf.Timestamp] with scalapb.TimestampCompanionMethods = this
  override protected def actualParseFrom(input: _root_.com.google.protobuf.CodedInputStream): com.google.protobuf.timestamp.Timestamp = newBuilder.merge(input).result()
  def toJavaProto(scalaPbSource: com.google.protobuf.timestamp.Timestamp): com.google.protobuf.Timestamp = {
    val javaPbOut = com.google.protobuf.Timestamp.newBuilder
    javaPbOut.setSeconds(scalaPbSource.seconds)
    javaPbOut.setNanos(scalaPbSource.nanos)
    javaPbOut.build
  }
  def fromJavaProto(javaPbSource: com.google.protobuf.Timestamp): com.google.protobuf.timestamp.Timestamp = com.google.protobuf.timestamp.Timestamp(
    seconds = javaPbSource.getSeconds.longValue,
    nanos = javaPbSource.getNanos.intValue
  )
  def merge(`_message__`: com.google.protobuf.timestamp.Timestamp, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.google.protobuf.timestamp.Timestamp = newBuilder(_message__).merge(_input__).result()
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.google.protobuf.timestamp.Timestamp] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.google.protobuf.timestamp.Timestamp(
        seconds = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
        nanos = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Int]).getOrElse(0)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = TimestampProto.javaDescriptor.getMessageTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = TimestampProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.google.protobuf.timestamp.Timestamp(
    seconds = 0L,
    nanos = 0
  )
  final class Builder private (
    private var __seconds: _root_.scala.Long,
    private var __nanos: _root_.scala.Int,
    private var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder
  ) extends _root_.scalapb.MessageBuilder[com.google.protobuf.timestamp.Timestamp] {
    def merge(`_input__`: _root_.com.google.protobuf.CodedInputStream): this.type = {
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 8 =>
            __seconds = _input__.readInt64()
          case 16 =>
            __nanos = _input__.readInt32()
          case tag =>
            if (_unknownFields__ == null) {
              _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
            }
            _unknownFields__.parseField(tag, _input__)
        }
      }
      this
    }
    def result(): com.google.protobuf.timestamp.Timestamp = {
      com.google.protobuf.timestamp.Timestamp(
        seconds = __seconds,
        nanos = __nanos,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
      )
    }
  }
  object Builder extends _root_.scalapb.MessageBuilderCompanion[com.google.protobuf.timestamp.Timestamp, com.google.protobuf.timestamp.Timestamp.Builder] {
    def apply(): Builder = new Builder(
      __seconds = 0L,
      __nanos = 0,
      `_unknownFields__` = null
    )
    def apply(`_message__`: com.google.protobuf.timestamp.Timestamp): Builder = new Builder(
      __seconds = _message__.seconds,
      __nanos = _message__.nanos,
      `_unknownFields__` = new _root_.scalapb.UnknownFieldSet.Builder(_message__.unknownFields)
    )
  }
  def newBuilder: Builder = com.google.protobuf.timestamp.Timestamp.Builder()
  def newBuilder(a: com.google.protobuf.timestamp.Timestamp): Builder = com.google.protobuf.timestamp.Timestamp.Builder(a)
  implicit class TimestampLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.google.protobuf.timestamp.Timestamp]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.google.protobuf.timestamp.Timestamp](_l) {
    def seconds: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.seconds)((c_, f_) => c_.copy(seconds = f_))
    def nanos: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.nanos)((c_, f_) => c_.copy(nanos = f_))
  }
  final val SECONDS_FIELD_NUMBER = 1
  final val NANOS_FIELD_NUMBER = 2
  def of(
    seconds: _root_.scala.Long,
    nanos: _root_.scala.Int
  ): _root_.com.google.protobuf.timestamp.Timestamp = _root_.com.google.protobuf.timestamp.Timestamp(
    seconds,
    nanos
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[google.protobuf.Timestamp])
}
