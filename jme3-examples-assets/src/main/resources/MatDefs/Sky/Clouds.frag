uniform float g_Time;

uniform sampler2D m_ColorMap;
uniform sampler2D m_GradientMap;
uniform sampler2D m_ShapeMap;
uniform sampler2D m_NoiseMap;
uniform sampler2D m_DetailMap;

uniform float m_Cover;
uniform float m_Density;
uniform float m_Height;
uniform float m_Sunset;
uniform float m_Speed;

varying vec2 texCoord;

void main() {
    float skyU = mod(g_Time * 0.041667, 1.0) + (texCoord.x * 0.04);
    float skyV = texture2D(m_GradientMap, texCoord).r;
    vec4 skyColor = texture2D(m_ColorMap, vec2(skyU, skyV));

    vec4 color = vec4(1.0);

    vec4 shape = texture2D(m_ShapeMap, texCoord + (g_Time * m_Speed));
    vec4 noise = texture2D(m_NoiseMap, texCoord + (g_Time * m_Speed * 1.1));
    vec4 detail = texture2D(m_DetailMap, texCoord);

    color = shape + noise * (1.0 - shape);
    color.a -= (1.0 - m_Cover);
    color.a *= 1.0 / clamp(m_Cover, 0.5, 1.0);
    color.rgb = color.rgb + detail.rgb * (1.0 - color.rgb);
    color.a *= detail.a * (1.0 - m_Density) + 1.0 * m_Density;
    if(color.a < 0.0) {
        color.r *= m_Density * color.a * 2.0;
        if(color.r > 1.0) {
            color.r = 1.0 - (color.r - 1.0) * 0.5;
        }
        color.g = color.r;
        color.b = color.r;
    }

    color = clamp(color, vec4(0.0), vec4(1.0));
    color.rgb *= (1.0 - skyColor.rgb) + skyColor.rgb * skyColor.a;
    gl_FragColor = color;
}
