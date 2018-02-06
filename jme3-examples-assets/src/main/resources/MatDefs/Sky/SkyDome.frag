uniform float g_Time;

uniform sampler2D m_ColorMap;
uniform sampler2D m_GradientMap;
uniform sampler2D m_StarMap;

varying vec2 texCoord;
varying float time;

void main(){
    vec3 g = texture2D(m_GradientMap, texCoord).rgb;
    float t = mod(g_Time / 60.0, 1.0) + (texCoord.x / 24.0);
    vec4 color = texture2D(m_ColorMap, vec2(t, g.r));
    float star = texture2D(m_StarMap, texCoord).r;

    if(all(lessThan(color.rgb + star, vec3(1.0)))) {
        color += star;
    }

    gl_FragColor = vec4(color.rgb, 1.0);
}
