// UNIFORMS

//uniform mat4 g_WorldMatrix;                       // The world matrix. Converts Model space to World space.
                                                    // (GLSL 1.0/0.2 gl_ModelViewMatrix)
//uniform mat4 g_WorldMatrixInverse;
//uniform mat4 g_ViewMatrix;                        // The view matrix. Converts World space to View space.
//uniform mat4 g_ViewMatrixInverse;
//uniform mat4 g_ProjectionMatrix;                  // The projection matrix. Converts View space to Clip/Projection
                                                    // space. (GLSL 1.0/0.2 gl_ProjectionMatrix)
//uniform mat4 g_ProjectionMatrixInverse;
//uniform mat4 g_WorldViewMatrix;                   // The view matrix. Converts World space to View space.
//uniform mat4 g_WorldViewMatrixInverse;
//uniform mat4 g_NormalMatrix;                      // The world view matrix. Converts Model space to View space.
                                                    // Converts normals from model space to view space.
                                                    // (GLSL 1.0/0.2 gl_NormalMatrix)
//uniform mat4 g_NormalMatrixInverse;
uniform mat4 g_WorldViewProjectionMatrix;           // The normal matrix. The inverse transpose of the worldview matrix.
                                                    // (GLSL 1.0/0.2 gl_ModelViewProjectionMatrix)
//uniform mat4 g_WorldViewProjectionMatrixInverse;
//uniform mat4 g_ViewProjectionMatrix;              // The view projection matrix. Converts World space to
                                                    // Clip/Projection space.
//uniform mat4 g_ViewProjectionMatrixInverse;

//uniform mat4 g_WorldMatrixInverseTranspose;       // The world matrix inverse transpose. Converts a normals from Model
                                                    // space to world space.

//uniform vec4 g_ViewPort;                          // Contains the four viewport parameters in this order:
//uniform vec2 g_FrustumNearFar;                    // The near and far values for the camera frustum.
//uniform vec2 g_Resolution;                        // The width and height of the camera.
//uniform vec2 g_ResolutionInverse;                 // The inverse of the resolution, 1/width and 1/height.
//uniform float g_Aspect;                           // Aspect ratio of the resolution currently set. Width/Height.

//uniform vec3 g_CameraPosition;                    // Camera position in world space.
//uniform vec3 g_CameraDirection;                   // Direction of the camera.
//uniform vec3 g_CameraLeft;                        // Left vector of the camera.
//uniform vec3 g_CameraUp;                          // Up vector of the camera.

//uniform float g_Time;                             // Time in seconds since the application was started.
//uniform float g_Tpf;                              // Time in seconds that the last frame took.
//uniform float g_FrameRate;                        // Frames per second.

//uniform vec4 g_LightDirection;                    // The light direction when rendering in multi pass mode
//uniform vec4 g_LightPosition;                     // The light position when rendering in multi pass mode
//uniform vec4 g_AmbientLightColor;                 // Ambient light color
//uniform vec4 g_LightColor;                        // The light color when rendering in multi pass mode

// ATTRIBUTES

attribute vec3 inPosition;                          // Position of the vertex. (GLSL 1.0/0.2 gl_Vertex)
//attribute float inSize;                           // The size of the point when using point buffers
//attribute vec3 inNormal;                          // Normal vector, normalized (GLSL 1.0/0.2 gl_Normal)
//attribute vec2 inTexCoord;                        // Texture coordinate (GLSL 1.0/0.2 gl_MultiTexCoord0)
//attribute vec4 inColor;                           // Color and Alpha (GLSL 1.0/0.2 gl_Color)
//attribute vec4 inTangent;                         // Tangent vector, normalized. The w component is called the
                                                    // binormal parity, is not normalized, and is either 1f or -1f. It's
                                                    // used to compute the direction on the binormal vector on the GPU
                                                    // at render time.
//attribute vec3 inBinormal;                        // Binormal vector, normalized
//attribute vec3 inBindPosePosition;                // Initial vertex position, used with animation.
//attribute vec3 inBindPoseNormal;                  // Initial vertex normals, used with animation.
//attribute vec4 inBoneWeight;                      // Bone weights, used with animation.
//attribute vec4 inBoneIndex;                       // Bone indices, used with animation.
//attribute vec2 inTexCoord2;                       // Texture coordinate #2.
//attribute vec2 inTexCoord3;                       // Texture coordinate #3.
//attribute vec2 inTexCoord4;                       // Texture coordinate #4.
//attribute vec2 inTexCoord5;                       // Texture coordinate #5.
//attribute vec2 inTexCoord6;                       // Texture coordinate #6.
//attribute vec2 inTexCoord7;                       // Texture coordinate #7.
//attribute vec2 inTexCoord8;                       // Texture coordinate #8.
//attribute vec4 inBindPoseTangent;                 // Initial vertex tangents, used with animation.
//attribute vec4 inHWBoneWeight;                    // Bone weights, used with animation.
//attribute vec4 inHWBoneIndex;                     // Bone indices, used with animation.

void main(){
    gl_Position = g_WorldViewProjectionMatrix * vec4(inPosition, 1.0);
}
