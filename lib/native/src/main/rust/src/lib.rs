//! Native library for FlorisBoard.
//! Provides FFI hooks for specialized logic.

use jni::objects::JClass;
use jni::sys::jint;
use jni::JNIEnv;

/// Dummy function to test JNI linkage.
/// Adds two integers and returns the result.
#[no_mangle]
pub extern "C" fn Java_org_florisboard_libnative_TestKt_dummyAdd(
    _env: JNIEnv,
    _class: JClass,
    a: jint,
    b: jint,
) -> jint {
    a + b
}
