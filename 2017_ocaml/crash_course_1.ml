let () =
  print_endline "Hello, world!"

let x = 10
let message = "Hello"

let y = ref 5

let () =
  y := !y + 1;
  Printf.printf "%d\n" !y

(* Comment *)
let u = [1; 2; 3; 4]

let print_int_list lst = 
  List.iter (fun x -> Printf.printf "%d " x) lst;
  print_newline ()

let () = 
  print_int_list u

let () =
  Printf.printf "%d" (50 + 50);
  Printf.printf "%d" 125;
  let x = 2 * if "hello" = "world" then 3 else 5 in
  Printf.printf "x=%d\n" x;
  (** Feets in a mile *)
  let feets = 5280 in
  Printf.printf "Feets in a mile %d\n" feets

let () =
  let a = 1 in
  let b = 2 in
    Printf.printf "a+b=%d\n" (a + b)

let () =
  let rec range lo hi =
    if lo > hi then
      []
    else
      lo :: range (lo + 1) hi
  in 
    let lst = range 2 5 in
    List.iter (Printf.printf "%d ") lst;
    print_newline ()


let () =
  let square x = x * x in 
  let rec map f u =
    match u with
    | [] -> []
    | x :: u -> f x :: map f u
  in
    let squared = map square [1; 2; 3; 4;] in
    List.iter (Printf.printf "%d ") squared

let () =
  let f opt = match opt with
  | None -> None
  | Some None -> None
  | Some (Some x) -> Some x
  in
    Printf.printf "test\n"


let () =
    let g x =
      if x = "foo" then 1
      else if x = "bar" then 2
      else if x = "baz" then 3
      else if x = "qux" then 4
      else 0 in
    Printf.printf "Val=%d\n" (g "qux")

let () =
  let g' x = match x with
    | "foo" -> 1
    | "bar" -> 2
    | "baz" -> 2
    | "qux" -> 4
    | _ -> 0;;

