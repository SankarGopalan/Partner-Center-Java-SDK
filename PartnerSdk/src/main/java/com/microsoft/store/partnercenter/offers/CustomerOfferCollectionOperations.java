// -----------------------------------------------------------------------
// <copyright file="CustomerOfferCollectionOperations.java" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------

package com.microsoft.store.partnercenter.offers;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.store.partnercenter.BasePartnerComponentString;
import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.PartnerService;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.offers.Offer;
import com.microsoft.store.partnercenter.network.IPartnerServiceProxy;
import com.microsoft.store.partnercenter.network.PartnerServiceProxy;
import com.microsoft.store.partnercenter.utils.StringHelper;

/***
 * Customer Offer operations implementation class.
 */
public class CustomerOfferCollectionOperations 
	extends BasePartnerComponentString 
	implements ICustomerOfferCollection
{

	/***
	 * Initializes a new instance of the CustomerOfferCollectionOperations class.
	 * 
	 * @param rootPartnerOperations: The root partner operations instance.
	 * @param customerId: The customer Id.
	 */
	public CustomerOfferCollectionOperations(IPartner rootPartnerOperations, String customerId )
	{
		super(rootPartnerOperations, customerId);
		if ( StringHelper.isNullOrEmpty( customerId ) )
        {
            throw new IllegalArgumentException("customerId must be set.");
        }
	}

	/***
	 * Gets the offers available to customer from partner.
	 */
	@Override
	public ResourceCollection<Offer> get()
	{
        IPartnerServiceProxy<ResourceCollection<Offer>, ResourceCollection<Offer>> partnerServiceProxy =
                new PartnerServiceProxy<ResourceCollection<Offer>, ResourceCollection<Offer>>( new TypeReference<ResourceCollection<Offer>>()
                {
                }, this.getPartner(), MessageFormat.format( PartnerService.getInstance().getConfiguration().getApis().get( "GetCustomerOffers" ).getPath(),
                                                            Locale.US ) );
        return partnerServiceProxy.get();
	}

	/***
	 * 
	 */
	@Override
	public ResourceCollection<Offer> get(int offset, int size)
	{
		return null;
	}

}
