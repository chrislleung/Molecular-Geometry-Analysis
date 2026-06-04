# Molecular Geometry Analysis Tools

This repository contains a suite of Java-based tools developed in 2023 to automate and process Density Functional Theory (DFT) calculations. 

These tools were specifically built to support the computational research and geometry analysis detailed in the published paper:
> **"DFT investigations of phenyldithiafulvene dimers at different oxidation states."** > *Liam H. Britt, Ramin Eradeh, Chris Leung, Yuming Zhao. Physical Chemistry Chemical Physics, 2023. DOI: [https://doi.org/10.1039/d3cp04122k](https://doi.org/10.1039/d3cp04122k)*

## Overview
When handling complex molecular geometries and multiple oxidation states, manually preparing input files and extracting geometric parameters becomes highly tedious and prone to error. This project serves as a pipeline to automate the manipulation of coordinate files, format inputs for computational chemistry software (like ORCA and Gaussian), and calculate highly specific structural properties using linear algebra.

## Key Modules / Features
This repository includes several standalone utilities designed for specific steps in the computational pipeline:

### Coordinate & File Formatting
* **XYZ Combiner & Decombiner:** Utilities to merge multiple `.xyz` files into a single trajectory file, or split a combined `.xyz` file back into multiple individual files.
* **Input Formatters (`xyz formatter`, `inp formatter`):** Automatically formats and converts `.xyz` coordinate files into `.gjf` (Gaussian) or `.inp` (ORCA) input files.
* **Coordinate Increments:** Automates the creation of coordinate scans by incrementing a specific X, Y, or Z value by a set number and generating new files for the incremented values.

### Geometric Analysis & Math Tools
* **Ring-Distance Calculator:** Parses atomic data to locate the geometric centers of specific rings and calculates the exact distance between two molecular rings.
* **Pyramidal Calculator:** Calculates the spatial distance between a specific point (atom) and the geometric center of three other points.
* **Angle Calculator:** Extracts specific atomic points from a file and uses linear algebra to define planes and calculate the angle between two planes.
* **Geometric Center:** Finds the geometric center of a molecule based on the positions of its atoms.
* **Pyrene Projection:** Uses linear algebra to predict the projection of a 3D pyrene molecule model onto a 2D plane.

### Data Extraction
* **ORCA Formatter:** Parses and formats raw ORCA program output files into clean `.xyz` and `.txt` files for easier reading.
* **Critical Point Extractor:** Scans through output files to search for an inputted critical point and extracts the relevant lines.

### User Interface
* **GUI:** A unified graphical user interface created to wrap all the above programs, allowing researchers to use the tools easily without needing the command line.

## Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher
* An IDE like IntelliJ IDEA or Eclipse (optional, for compiling source code)

### Running the Tools
The easiest way to use these utilities is by running the main `gui.java` class, which opens a visual menu allowing you to select and run any of the geometric calculators or formatters. Alternatively, the individual tools (like `ring-distance calculator` or `xyz combiner`) can be run as standalone Java applications from the command line.

## Citation
If you use these scripts in your own workflow, please consider citing our paper:

**Plain Text (APA Style):**
> Britt, L. H., Eradeh, R., Leung, C., & Zhao, Y. (2023). DFT investigations of phenyldithiafulvene dimers at different oxidation states. *Physical Chemistry Chemical Physics*. https://doi.org/10.1039/D3CP04122K

**BibTeX:**
```bibtex
@article{britt2023dft,
  title={DFT investigations of phenyldithiafulvene dimers at different oxidation states},
  author={Britt, Liam H. and Eradeh, Ramin and Leung, Chris and Zhao, Yuming},
  journal={Physical Chemistry Chemical Physics},
  year={2023},
  publisher={Royal Society of Chemistry},
  doi={10.1039/D3CP04122K}
}
