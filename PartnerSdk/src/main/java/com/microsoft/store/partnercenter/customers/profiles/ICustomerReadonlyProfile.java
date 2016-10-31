// -----------------------------------------------------------------------
// <copyright file="ICustomerReadonlyProfile.java" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------

package com.microsoft.store.partnercenter.customers.profiles;

import com.microsoft.store.partnercenter.IPartnerComponentString;
import com.microsoft.store.partnercenter.genericoperations.IEntityGetOperations;
import com.microsoft.store.partnercenter.models.ResourceBase;

/***
 * 
 * Encapsulates a single customer read-only profile behavior.
 * @type-param="T": The type of the customer profile.
 */
public interface ICustomerReadonlyProfile<T extends ResourceBase> 
	extends IPartnerComponentString, IEntityGetOperations<T> 
{
	
    /*** 
     * Retrieves the customer profile.
     * @returns: The customer profile.
     */
    T get();

}
