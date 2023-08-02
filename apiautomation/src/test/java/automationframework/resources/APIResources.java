package automationframework.resources;

public enum APIResources {
	GetAPISample("/v3.1/all"),
	PostAPISample("/objects");	
    private final String resource;

    private APIResources(final String resource)    
    {
        this.resource=resource;
    }
    
  public String getResource()
  {
      return resource;
  }
}