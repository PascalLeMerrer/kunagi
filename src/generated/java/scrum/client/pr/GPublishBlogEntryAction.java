// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.GwtActionGenerator










package scrum.client.pr;

import java.util.*;

public abstract class GPublishBlogEntryAction
            extends scrum.client.common.AScrumAction {

    protected scrum.client.pr.BlogEntry blogEntry;

    public GPublishBlogEntryAction(scrum.client.pr.BlogEntry blogEntry) {
        this.blogEntry = blogEntry;
    }

    @Override
    public boolean isExecutable() {
        return true;
    }

}