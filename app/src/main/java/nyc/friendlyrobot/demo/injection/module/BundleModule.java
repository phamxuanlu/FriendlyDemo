package nyc.friendlyrobot.demo.injection.module;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import dagger.Module;
import dagger.Provides;
import nyc.friendlyrobot.demo.injection.ScopeActivity;
import nyc.friendlyrobot.demo.ui.base.BaseActivity;
import nyc.friendlyrobot.demo.util.BundleService;


@Module
public class BundleModule {

    @Provides
    public Bundle provideBundle(Activity context) {
        return context.getIntent().getExtras() == null ? new Bundle() : context.getIntent().getExtras();
    }

    @Provides
    public Intent provideIntent(Activity context) {
        return context.getIntent() == null ? new Intent() : context.getIntent();
    }

    @Provides
    @ScopeActivity
    public BundleService provideBundleService(Activity context) {
        return ((BaseActivity) context).getBundleService();
    }

//    @RouteId
//    @ScopeActivity
//    @Provides
//    Long provideRouteLongId(BundleService bundleService) {
//        return (Long) bundleService.get(EXTRA_ROUTE);
//    }

}
