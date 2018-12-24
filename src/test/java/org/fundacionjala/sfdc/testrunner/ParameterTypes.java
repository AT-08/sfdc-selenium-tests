package org.fundacionjala.sfdc.testrunner;

import java.util.Locale;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellTransformer;

import org.fundacionjala.sfdc.pages.accounts.AccountInputs;
import org.fundacionjala.sfdc.pages.campaigns.CampaignInputs;
import org.fundacionjala.sfdc.pages.contacts.ContactInputs;
import org.fundacionjala.sfdc.pages.opportunities.OpportInputs;

/**
 * Registers parameters types.
 */
public class ParameterTypes implements TypeRegistryConfigurer {

    /**
     * {@inheritDoc}
     */
    public Locale locale() {
        return Locale.ENGLISH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configureTypeRegistry(final TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(AccountInputs.class,
                (TableCellTransformer<AccountInputs>) cell -> AccountInputs.valueOf(cell.toUpperCase())));
        typeRegistry.defineDataTableType(new DataTableType(CampaignInputs.class,
                (TableCellTransformer<CampaignInputs>) cell -> CampaignInputs.valueOf(cell.toUpperCase())));
        typeRegistry.defineDataTableType(new DataTableType(ContactInputs.class,
                (TableCellTransformer<ContactInputs>) cell -> ContactInputs.valueOf(cell.toUpperCase())));
        typeRegistry.defineDataTableType(new DataTableType(OpportInputs.class,
                (TableCellTransformer<OpportInputs>) cell -> OpportInputs.valueOf(cell.toUpperCase())));
    }
}
