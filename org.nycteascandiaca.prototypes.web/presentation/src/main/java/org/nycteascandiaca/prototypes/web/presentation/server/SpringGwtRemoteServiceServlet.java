package org.nycteascandiaca.prototypes.web.presentation.server;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SpringGwtRemoteServiceServlet extends RemoteServiceServlet
{
	private static final long serialVersionUID = 8246048886754797416L;

	@Override
	public String processCall(String payload) throws SerializationException
	{
		try
		{
			Object handler = getBean(getThreadLocalRequest());
			RPCRequest rpcRequest = RPC.decodeRequest(payload, handler.getClass(), this);
			onAfterRequestDeserialized(rpcRequest);
			return RPC.invokeAndEncodeResponse
			(
					handler,
					rpcRequest.getMethod(),
					rpcRequest.getParameters(),
					rpcRequest.getSerializationPolicy()
			);
		}
		catch (IncompatibleRemoteServiceException ex)
		{
			return RPC.encodeResponseForFailure(null, ex);
		}
	}

	protected Object getBean(HttpServletRequest request)
	{
		String service = getService(request);
		Object bean = getBean(service);
		if (!(bean instanceof RemoteService))
		{
			throw new IllegalArgumentException("Spring bean is not a GWT RemoteService: " + service + " (" + bean + ")");
		}
		return bean;
	}

	protected String getService(HttpServletRequest request)
	{
		String url = request.getRequestURI();
		String service = url.substring(url.lastIndexOf("/") + 1);
		return service;
	}

	protected Object getBean(String name)
	{
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		if (applicationContext == null)
		{
			throw new IllegalStateException("No Spring web application context found");
		}
		if (!applicationContext.containsBean(name))
		{
			throw new IllegalArgumentException("Spring bean not found: " + name);
		}
		return applicationContext.getBean(name);
	}
}
