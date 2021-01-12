package io.github.emfsilva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.emfsilva.doman.SimpleMath;
import io.github.emfsilva.exception.UnsuportedMathOperationException;
import io.github.emfsilva.request.convert.ConvertNumbers;

@RestController
public class MathController {
	
	@Autowired
	private SimpleMath math;
	
	@Autowired
	private ConvertNumbers convert;
	
	// soma
	@RequestMapping(value = "sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!convert.isNumeric(numberOne) || !convert.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		return math.sum(convert.convertToDouble(numberOne), convert.convertToDouble(numberTwo));
	}

	// subtração
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!convert.isNumeric(numberOne) || !convert.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		return math.subtraction(convert.convertToDouble(numberOne), convert.convertToDouble(numberTwo));
	}

	// multiplicação
	@RequestMapping(value = "/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mul(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!convert.isNumeric(numberOne) || !convert.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		return math.multiplication(convert.convertToDouble(numberOne), convert.convertToDouble(numberTwo));
	}


	// Divisão
	@RequestMapping(value = "div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!convert.isNumeric(numberOne) || !convert.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		return math.division(convert.convertToDouble(numberOne), convert.convertToDouble(numberTwo));
	}

	// Média
	@RequestMapping(value = "mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double med(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!convert.isNumeric(numberOne) || !convert.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		return math.mean(convert.convertToDouble(numberOne), convert.convertToDouble(numberTwo));
	}
	
	// Raiz quadrada
	@RequestMapping(value = "sqrt/{number}", method = RequestMethod.GET)
	public Double sqrt(@PathVariable("number") String number) throws Exception {
		if (!convert.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		 return math.squareRoot(convert.convertToDouble(number));
	}
}
