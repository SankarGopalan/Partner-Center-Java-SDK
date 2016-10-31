// -----------------------------------------------------------------------
// <copyright file="IInvoiceSummary.java" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------

package com.microsoft.store.partnercenter.invoices;

import com.microsoft.store.partnercenter.IPartnerComponentString;
import com.microsoft.store.partnercenter.genericoperations.IEntityGetOperations;
import com.microsoft.store.partnercenter.models.invoices.Summary;

public interface IInvoiceSummary
	extends IPartnerComponentString, IEntityGetOperations<Summary>
{
    /***
     * Retrieves the invoice summary. This operation is currently only supported for user based credentials.
     * 
     * @return: The invoice summary.
     */
    Summary get();
}
