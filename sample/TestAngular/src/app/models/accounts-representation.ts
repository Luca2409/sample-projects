export interface Account {
  accountId: string;
  balances: {
    available: number | null;
    current: number;
    limit: number | null;
    isoCurrencyCode: string;
    unofficialCurrencyCode: string | null;
    lastUpdatedDatetime: string | null;
  };
  mask: string;
  name: string;
  officialName: string | null;
  type: string;
  subtype: string;
  verificationStatus: string | null;
  verificationName: string | null;
  verificationInsights: string | null;
  persistentAccountId: string | null;
  holderCategory: string | null;
}

export interface Item {
  itemId: string;
  institutionId: string;
  institutionName: string;
  webhook: string;
  authMethod: string;
  error: string | null;
  availableProducts: string[];
  billedProducts: string[];
  products: string[];
  consentedProducts: string[] | null;
  consentExpirationTime: string | null;
  updateType: string;
}
export interface balances {

  available: bigint;
  current: bigint;
  limit: bigint;
  isoCurrencyCode: string;
  unofficialCurrencyCode: string;
  lastUpdatedDatetime: string;
}

export interface AccountsResponse{

  accountId: string;
  balances: balances;
  name: string;
  officialName: string;

}

export class Test {
  accountId?: string;
  balances?: balances;
  name?: string;
  officialName?: string;
}
