package plugins;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lplugins/LocalDateSerializer;", "Lkotlinx/serialization/KSerializer;", "Ljava/time/LocalDate;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "formatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "ktor-demo"})
public final class LocalDateSerializer implements kotlinx.serialization.KSerializer<java.time.LocalDate> {
    private static final java.time.format.DateTimeFormatter formatter = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.serialization.descriptors.SerialDescriptor descriptor = null;
    @org.jetbrains.annotations.NotNull()
    public static final plugins.LocalDateSerializer INSTANCE = null;
    
    private LocalDateSerializer() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
        return null;
    }
    
    @java.lang.Override()
    public void serialize(@org.jetbrains.annotations.NotNull()
    kotlinx.serialization.encoding.Encoder encoder, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate value) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.time.LocalDate deserialize(@org.jetbrains.annotations.NotNull()
    kotlinx.serialization.encoding.Decoder decoder) {
        return null;
    }
}