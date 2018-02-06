uniform float g_Time;

uniform sampler2D m_ColorMap;
uniform sampler2D m_GradientMap;
uniform sampler2D m_StarMap;
uniform sampler2D m_GalaxyMap;

varying vec2 texCoord;

void main() {
    float skyU = mod(g_Time * 0.041667, 1.0) + (texCoord.x * 0.04);
    float skyV = texture2D(m_GradientMap, texCoord).r;
    vec3 sky = texture2D(m_ColorMap, vec2(skyU, skyV)).rgb;
    vec4 star = texture2D(m_StarMap, texCoord);
    if(star.a > 0.0) {
        float shine = ((star.a + texture2D(m_GalaxyMap, texCoord).r) + (star.r * sin(star.b + (g_Time * star.g)))) / 3.0;
        float light = max(sky.r, sky.g);
        light = max(light, sky.b);
        if(light < shine) {
            sky = light < 0.5 ? vec3(shine) : sky * (1.0 - shine) + shine;
        }
    }
    gl_FragColor = vec4(sky, 1.0);
}
