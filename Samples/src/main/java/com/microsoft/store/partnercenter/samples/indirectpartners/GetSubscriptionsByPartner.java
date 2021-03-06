// -----------------------------------------------------------------------
// <copyright file="GetSubscriptionsByPartner.java" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------

package com.microsoft.store.partnercenter.samples.indirectpartners;

import java.text.MessageFormat;

import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.subscriptions.Subscription;
import com.microsoft.store.partnercenter.samples.BasePartnerScenario;
import com.microsoft.store.partnercenter.samples.IScenarioContext;

/**
 * A scenario that gets a customer's subscriptions which belong to a partner MPN ID.
 */
public class GetSubscriptionsByPartner
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetSubscriptionsByPartner} class.
     * 
     * @param context The scenario context.
     */
    public GetSubscriptionsByPartner( IScenarioContext context )
    {
        super( "Get customer subscriptions by partner MPN ID", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        String customerId = this.obtainCustomerIdForUsage("");
        String partnerMpnId = this.obtainMpnId();
        IPartner partnerOperations = this.getContext().getUserPartnerOperations();
        this.getContext().getConsoleHelper().startProgress( "Getting subscriptions" );
        ResourceCollection<Subscription> customerSubscriptionsByMpnId =
            partnerOperations.getCustomers().byId( customerId ).getSubscriptions().byPartner( partnerMpnId ).get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( customerSubscriptionsByMpnId,
                                                          MessageFormat.format( "Customer subscriptions by Partner MPN ID: {0}",
                                                                                partnerMpnId ) );
    }

}
