# Vehicle Management System

Student: Hadis Delbord - 7222043

This Java application demonstrates a vehicle management system that handles various types of vehicles like Internal Combustion Engine Vehicles (ICEV), Battery Electric Vehicles (BEV), and Hybrid Vehicles (HybridV). The program allows users to filter cars based on certain criteria and export the result to a text file.

## Project Structure

The project is structured with the following classes:

**Engine** (Superclass for vehicle engines)
  - `CombustionEngine`
  - `ElectricEngine`
  - `HybridEngine`
  
**Manufacture** (Represents vehicle manufacturers)
  
**Vehicle** (Abstract superclass for vehicles)
  - `ICEV` (Internal Combustion Engine Vehicle)
  - `BEV` (Battery Electric Vehicle)
  - `HybridV` (Hybrid Vehicle)
  
**Main** (Contains the application logic for filtering vehicles and saving data to a file)

### Features

**Vehicle Types**: 
   - ICEV (Internal Combustion Engine Vehicles)
   - BEV (Battery Electric Vehicles)
   - HybridV (Hybrid Vehicles combining Combustion and Electric Engines)
   
**Filtering Options**: 
   - List cars of a given brand
   - List cars of a given model that have been in use for more than a specified number of years
   - List cars of a specific year of manufacture with a price higher than a specified amount

**Save Filtered Results**: The filtered results are saved to an `output.txt` file.


 **Output**:
   - If the filter criteria match any vehicles, the result will be saved to `output.txt` located in the root directory of the project. If no results match, a message will be displayed in the console.
