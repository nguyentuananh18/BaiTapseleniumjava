package anhNT.configData;

import anhNT.helpers.PropertiesHelper;

public class ConfigData {
    public String URL = PropertiesHelper.getPropValue("url");
    public String username = PropertiesHelper.getPropValue("email");
    public String password = PropertiesHelper.getPropValue("password");
}
