package com.unep.wcmc.security;

import com.unep.wcmc.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("activeUserAccessor")
public class ActiveUserAccessorImpl implements ActiveUserAccessor
{
    public User getActiveUser()
    {
        return (User) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }
}
