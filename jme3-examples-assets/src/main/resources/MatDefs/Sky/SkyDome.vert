uniform mat4 g_WorldViewProjectionMatrix;
uniform float g_Time;

attribute vec3 inPosition;
attribute vec2 inTexCoord;

varying vec2 texCoord;
varying float time;

void main(){
    texCoord = inTexCoord;
    time = g_Time;
    gl_Position = g_WorldViewProjectionMatrix * vec4(inPosition, 1.0);
}
