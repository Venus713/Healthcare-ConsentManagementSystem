require("dotenv").config();
const { ethers } = require("hardhat");

async function main() {
    const [deployer] = await ethers.getSigners();
    console.log("Deploying contracts with the account:", deployer.address);
    console.log("Account balance:", (await deployer.getBalance()).toString());
    const Consent = await ethers.getContractFactory("ConsentManagementSystem");
    const COMPANY = "CONSENTTEST"

    // const Consent = await ethers.getContractFactory("ConnectionFile");

    // const Consent = await ethers.getContractFactory("ConsentFile");

    const contract = await Consent.deploy(COMPANY);
  
    await contract.deployed();
  
    console.log("CMS smart contract deployed to:", contract.address);
}
  
main()
    .then(() => process.exit(0))
    .catch((error) => {
        console.error(error);
        process.exit(1);
    });