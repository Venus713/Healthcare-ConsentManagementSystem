require("dotenv").config();

require('@openzeppelin/hardhat-upgrades');
require('@nomiclabs/hardhat-waffle');
require("hardhat-gas-reporter");
require("hardhat-contract-sizer");
require("@nomiclabs/hardhat-ethers");
require("@nomiclabs/hardhat-etherscan");

// You need to export an object to set up your config
// Go to https://hardhat.org/config/ to learn more

/**
 * @type import('hardhat/config').HardhatUserConfig
 */
//  npx hardhat run scripts/sample-script.js --network localhost

const FORK_FUJI = false
const FORK_MAINNET = false
const forkingData = FORK_FUJI
  ? {
      url: "https://api.avax-test.network/ext/bc/C/rpc",
    }
  : FORK_MAINNET
  ? {
      url: "https://api.avax.network/ext/bc/C/rpc",
    }
  : undefined


module.exports = {
  solidity: "0.5.2",
  networks: {
    fuji: {
      url: process.env.AVALANCHE_FUJI_URL || "",
      gas: 2100000,
      gasPrice: 225000000000,
      chainId: 43113,
      accounts: process.env.PRIVATE_KEY !== undefined ? [process.env.PRIVATE_KEY] : [],
    },
    mainnet: {
      url: process.env.AVALANCHE_URL || "",
      gasPrice: 225000000000,
      chainId: 43114,
      accounts: process.env.PRIVATE_KEY !== undefined ? [process.env.PRIVATE_KEY] : [],
    },
  },
  paths: {
    sources: "./Backend/ConsentManagement/Contracts",
    tests: "./Backend/ConsentManagement/Contracts/test",
    cache: "./Backend/ConsentManagement/Contracts/cache",
    artifacts: "./Backend/ConsentManagement/Contracts/artifacts"

    // sources: "./Backend/ConsentManagement/Contracts/Connection",
    // tests: "./Backend/ConsentManagement/Contracts/test/connection",
    // cache: "./Backend/ConsentManagement/Contracts/cache/connection",
    // artifacts: "./Backend/ConsentManagement/Contracts/artifacts/connection"

    // sources: "./Backend/ConsentManagement/Contracts/Consent",
    // tests: "./Backend/ConsentManagement/Contracts/test/consent",
    // cache: "./Backend/ConsentManagement/Contracts/cache/consent",
    // artifacts: "./Backend/ConsentManagement/Contracts/artifacts/consent"
  },
  gasReporter: {
    enabled: process.env.REPORT_GAS !== undefined,
    currency: "USD",
  },
  settings: {
    optimizer: {
      enabled: true,
      runs: 1,
    }
  },
};
