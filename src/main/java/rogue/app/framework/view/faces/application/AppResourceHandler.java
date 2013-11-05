package rogue.app.framework.view.faces.application;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A custom resource handler implementation that wraps resources which are local to the webapp to use a web friendly
 * URL instead of the standard javax.faces.resources/** URL.
 */
public class AppResourceHandler extends ResourceHandlerWrapper
{
    private ResourceHandler wrapped;
    private String resourcesRoot;

    public AppResourceHandler(ResourceHandler wrapped)
    {
        this.wrapped = wrapped;
    }

    @Override
    public ResourceHandler getWrapped()
    {
        return wrapped;
    }

    @Override
    public Resource createResource(String resourceName)
    {
        return getWrappedResource(super.createResource(resourceName));
    }

    @Override
    public Resource createResource(String resourceName, String libraryName)
    {
        return getWrappedResource(super.createResource(resourceName, libraryName));
    }

    @Override
    public Resource createResource(String resourceName, String libraryName, String contentType)
    {
        return getWrappedResource(super.createResource(resourceName, libraryName, contentType));
    }

    @Override
    public Resource createResourceFromId(String resourceId)
    {
        return getWrappedResource(super.createResourceFromId(resourceId));
    }

    /**
     * If the given resource object can be rendered locally, then do so by returning a wrapped object, otherwise
     * return the input as is.
     *
     * @param resource - the input resource object.
     * @return a wrapped resource object if given input can be rendered locally instead.
     */
    private Resource getWrappedResource(Resource resource)
    {
        WebAppResource webAppResource = null;
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        initResourcesRoot(context);

        if (resource != null)
        {
            URL baseURL = resource.getURL();
            if (baseURL != null)
            {
                String extForm = baseURL.toExternalForm();
                int idx = extForm.indexOf(resourcesRoot);
                if (idx != -1)
                {
                    try
                    {
                        extForm = extForm.substring(idx);
                        URL resourceURL = context.getResource(extForm);
                        if (resourceURL != null)
                        {
                            webAppResource = new WebAppResource(extForm, resource);
                        }
                    }
                    catch (MalformedURLException e)
                    {
                        // Do nothing.
                    }
                }
            }
        }
        return webAppResource != null ? webAppResource : resource;
    }

    /**
     * Initialize the resources root.
     *
     * @param context the external context associated with the current app.
     */
    private void initResourcesRoot(ExternalContext context)
    {
        if (resourcesRoot == null)
        {
            resourcesRoot = context.getInitParameter(ResourceHandler.WEBAPP_RESOURCES_DIRECTORY_PARAM_NAME);
            if (resourcesRoot == null)
            {
                resourcesRoot = "/resources";
            }
        }
    }
}
