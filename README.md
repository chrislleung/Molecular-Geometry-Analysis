# Molecular Geometry Analysis Tools

This repository contains a suite of Java-based tools developed in 2023 to automate and process Density Functional Theory (DFT) calculations. 

These tools were specifically built to support the computational research and geometry analysis detailed in the published paper:
> **"DFT investigations of phenyldithiafulvene dimers at different oxidation states."** > *[Authors list, Journal Name, Year. DOI: insert link here]*

## 📌 Overview
When handling complex molecular geometries and multiple oxidation states, manually preparing input files and extracting geometric parameters becomes highly tedious and prone to error. This project serves as a pipeline to automate the manipulation of coordinate files, format inputs for computational chemistry software (like ORCA and Gaussian), and calculate highly specific structural properties using linear algebra.

## ⚙️ Key Modules / Features
This repository includes several standalone utilities designed for specific steps in the computational pipeline:

### Coordinate & File Formatting
* [cite_start]**XYZ Combiner & Decombiner:** Utilities to merge multiple `.xyz` files into a single trajectory file, or split a combined `.xyz` file back into multiple individual files.
* [cite_start]**Input Formatters (`xyz formatter`, `inp formatter`):** Automatically formats and converts `.xyz` coordinate files into `.gjf` (Gaussian) or `.inp` (ORCA) input files.
* [cite_start]**Coordinate Increments:** Automates the creation of coordinate scans by incrementing a specific X, Y, or Z value by a set number and generating new files for the incremented values.

### Geometric Analysis & Math Tools
* [cite_start]**Ring-Distance Calculator:** Parses atomic data to locate the geometric centers of specific rings and calculates the exact distance between two molecular rings[cite: 1, 2].
* [cite_start]**Pyramidal Calculator:** Calculates the spatial distance between a specific point (atom) and the geometric center of three other points.
* [cite_start]**Angle Calculator:** Extracts specific atomic points from a file and uses linear algebra to define planes and calculate the angle between two planes.
* [cite_start]**Geometric Center:** Finds the geometric center of a molecule based on the positions of its atoms.
* [cite_start]**Pyrene Projection:** Uses linear algebra to predict the projection of a 3D pyrene molecule model onto a 2D plane.

### Data Extraction
* [cite_start]**ORCA Formatter:** Parses and formats raw ORCA program output files into clean `.xyz` and `.txt` files for easier reading.
* [cite_start]**Critical Point Extractor:** Scans through output files to search for an inputted critical point and extracts the relevant lines.

### User Interface
* [cite_start]**GUI:** A unified graphical user interface created to wrap all the above programs, allowing researchers to use the tools easily without needing the command line.

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher
* (Optional) An IDE like IntelliJ IDEA to compile the source code.

### Running the Tools
The easiest way to use these utilities is by running the main `gui.java` class, which opens a menu allowing you to select and run any of the geometric calculators or formatters visually. Alternatively, the individual tools (like `ring-distance calculator` or `xyz combiner`) can be run as standalone Java applications.

## 📖 Citation
If you use these scripts in your own workflow, please consider citing our paper:
```text
[Insert formal citation here]
